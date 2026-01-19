package org.example;

import com.vmlens.api.AllInterleavings;
import com.vmlens.api.Runner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * CORRECT: The volatile write to 'ready' acts as a memory barrier.
 * All writes BEFORE the volatile write (data = 42) are guaranteed
 * to be visible to any thread that reads the volatile 'ready' as true.
 */
public class T10_VolatileBarrierCorrectTest {

    static class CorrectVolatileBarrier {
        private int data = 0;           // non-volatile
        private volatile boolean ready = false;  // volatile flag

        public void writer() {
            data = 42;      // 1. write to non-volatile
            ready = true;   // 2. volatile write - acts as RELEASE barrier
        }

        public int reader() {
            if (ready) {    // 1. volatile read - acts as ACQUIRE barrier
                return data; // 2. guaranteed to see data = 42
            }
            return -1;      // not ready yet
        }
    }

    @Test
    void testCorrectVolatileBarrier() {
        try (var interleavings = new AllInterleavings("VolatileBarrierCorrect", true)) {
            while (interleavings.hasNext()) {
                var barrier = new CorrectVolatileBarrier();
                final int[] result = {-1};

                Runner.runParallel(
                        () -> {
                            barrier.writer();
                        },
                        () -> {
                            result[0] = barrier.reader();
                        }
                );

                // If we saw ready=true, we MUST see data=42
                // Result is either -1 (not ready) or 42 (correct value)
                Assertions.assertTrue(
                        result[0] == -1 || result[0] == 42,
                        "If ready was true, data must be 42, but got: " + result[0]
                );
            }
        }
    }
}
