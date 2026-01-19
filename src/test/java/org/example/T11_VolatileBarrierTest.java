package org.example;

import com.vmlens.api.AllInterleavings;
import com.vmlens.api.Runner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class T11_VolatileBarrierTest {

    static class VolatileBarrier {
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
    void testVolatileBarrier() {
        try (var interleavings = new AllInterleavings("VolatileBarrier_11", true)) {
            while (interleavings.hasNext()) {
                var barrier = new VolatileBarrier();
                final int[] result = {-1};
                final boolean[] sawReady = {false};

                Runner.runParallel(
                        barrier::writer,
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
                Assertions.assertTrue(
                        result[0] == -1 || result[0] == 42,
                        "If ready was true, data must be 42, but got: " + result[0]
                );
            }
        }
    }
}
