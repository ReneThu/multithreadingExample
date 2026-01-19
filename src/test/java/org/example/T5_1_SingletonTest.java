package org.example;

import com.vmlens.api.AllInterleavings;
import com.vmlens.api.Runner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;


class T5_1_SingletonTest {

    public final class LazyRace<T> {
        private T v;
        private final Supplier<? extends T> factory;

        public LazyRace(Supplier<? extends T> factory) {
            this.factory = factory;
        }

        public T get() {
            T lv = v;
            if (lv == null) {
                lv = factory.get();
                v = lv;
            }
            return lv;
        }
    }

    public final class Data {
        public int i = 42;
    }

    @Test
    void test() {
        try (var interleavings = new AllInterleavings("Singleton 5.1", true)) {
            while (interleavings.hasNext()) {
                var lr = new LazyRace<>(Data::new);
                Runner.runParallel(
                        () -> {
                            Data d = lr.get();
                            Assertions.assertEquals(42, d.i);
                        },
                        () -> {
                            Data d = lr.get();
                            Assertions.assertEquals(42, d.i);
                        }
                );
            }
        }
    }
}
