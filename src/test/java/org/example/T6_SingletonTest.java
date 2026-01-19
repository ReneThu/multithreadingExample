package org.example;

import com.vmlens.api.AllInterleavings;
import com.vmlens.api.Runner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;


class T6_SingletonTest {

    //Somewhat correct
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
        public final int i = 42;
    }

    @Test
    void test() {
        try (var interleavings = new AllInterleavings("Singleton 6", true)) {
            while (interleavings.hasNext()) {
                Runner.runParallel(
                        () -> {
                            LazyRace<Data> lr = new LazyRace(() -> new Data());
                            Data d = lr.get();
                            Assertions.assertEquals(42, d.i);
                        },
                        () -> {
                            LazyRace<Data> lr = new LazyRace(() -> new Data());
                            Data d = lr.get();
                            Assertions.assertEquals(42, d.i);
                        }
                );
            }
        }
    }
}
