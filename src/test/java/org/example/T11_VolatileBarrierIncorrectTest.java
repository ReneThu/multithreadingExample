package org.example;

import com.vmlens.api.AllInterleavings;
import com.vmlens.api.Runner;
import org.junit.jupiter.api.Test;

/**
 * INCORRECT: The volatile is on the WRONG variable!
 * The volatile write to 'data' happens BEFORE the non-volatile write to 'ready'.
 * This means:
 * - Thread 2 might see ready=true (reordered/cached) but data=0
 * - The barrier doesn't protect the flag we're checking
 */
public class T11_VolatileBarrierIncorrectTest {

    static class IncorrectVolatileBarrier {
        private volatile int data = 0;  // volatile on data
        private boolean ready = false;  // non-volatile flag - WRONG!

        public void writer() {
            data = 42;      // 1. volatile write - barrier here is too early!
            ready = true;   // 2. non-volatile write - can be reordered/not visible
        }

        public int reader() {
            if (ready) {    // 1. non-volatile read - might see stale value or reordered
                return data; // 2. volatile read - but barrier is too late!
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

                // With vmlens, this test may reveal the race condition:
                // sawReady could be true but result could theoretically be 0
                // due to improper synchronization
                if (sawReady[0]) {
                    System.out.println("Saw ready=true, data=" + result[0]);
                    // This assertion might fail with vmlens exploring interleavings
                    // Assertions.assertEquals(42, result[0]); // UNSAFE!
                }
            }
        }
    }
}
