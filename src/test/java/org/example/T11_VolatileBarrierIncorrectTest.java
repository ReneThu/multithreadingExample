package org.example;

import com.vmlens.api.AllInterleavings;
import com.vmlens.api.Runner;
import org.junit.jupiter.api.Test;

public class T11_VolatileBarrierIncorrectTest {

    static class IncorrectVolatileBarrier {
        private volatile int data = 0;
        private boolean ready = false;

        public void writer() {
            data = 42;      
            ready = true;   
        }

        public int reader() {
            if (ready) {    
                return data; 
            }
            return -1;
        }
    }

    @Test
    void testIncorrectVolatileBarrier() {
        try (var interleavings = new AllInterleavings("VolatileBarrierIncorrect", true)) {
            while (interleavings.hasNext()) {
                var barrier = new IncorrectVolatileBarrier();
                final int[] result = {-1};
                final boolean[] sawReady = {false};

                Runner.runParallel(
                        () -> {
                            barrier.writer();
                        },
                        () -> {
                            int r = barrier.reader();
                            if (r != -1) {
                                sawReady[0] = true;
                                result[0] = r;
                            }
                        }
                );

                if (sawReady[0]) {
                    System.out.println("Saw ready=true, data=" + result[0]);
                }
            }
        }
    }
}
