package org.example;

import com.vmlens.api.AllInterleavings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static com.vmlens.api.Runner.runParallel;

class T0_1_NonVolatileAndVolatileTest {
    static class Counter {
        int i = 0;
        volatile int v = 0;
        final AtomicInteger atomicInteger = new AtomicInteger(0);

        void increment() {
            i++;
        }

        void incrementVolatile() {
            v++;
        }

        void incrementAtomic() {
            atomicInteger.incrementAndGet();
        }
    }

    @Test
    void volatileTest() {
        try (var interleavings = new AllInterleavings("Volatile increment", true)) {
            while (interleavings.hasNext()) {
                var c = new Counter();
                runParallel(
                        c::incrementVolatile,
                        c::incrementVolatile
                );
                Assertions.assertEquals(2, c.v);
            }
        }
    }

    @Test
    void nonVolatileTest() {
        try (var interleavings = new AllInterleavings("Non Volatile increment", true)) {
            for (var interleaving : interleavings) {
                var c = new Counter();
                runParallel(
                        c::increment,
                        c::increment
                );
                Assertions.assertEquals(2, c.i);
            }
        }
    }

    @Test
    void atomicTest() {
        try (var interleavings = new AllInterleavings("Atomic increment", true)) {
            for (var interleaving : interleavings) {
                var c = new Counter();
                runParallel(
                        c::incrementAtomic,
                        c::incrementAtomic
                );
                Assertions.assertEquals(2, c.atomicInteger.get());
            }
        }
    }
}
