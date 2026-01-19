package org.example;

import com.vmlens.api.AllInterleavings;
import com.vmlens.api.Runner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class T10_VolatileBarrierTest {

    static class VolatileBarrier {
        private int data = 0;           
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
    void testVolatileBarrier() throws InterruptedException {
        try (var interleavings = new AllInterleavings("VolatileBarrier_10", true)) {
            while (interleavings.hasNext()) {
                var barrier = new VolatileBarrier();
                final int[] result = {-1};

                Runner.runParallel(
                        barrier::writer,
                        () -> result[0] = barrier.reader()
                );

                Assertions.assertTrue(
                        result[0] == -1 || result[0] == 42,
                        "If ready was true, data must be 42, but got: " + result[0]
                );
            }
        }
    }
}
