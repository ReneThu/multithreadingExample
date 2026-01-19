package org.example;

import org.junit.jupiter.api.Test;

import java.util.function.Supplier;


class SingletonTests_six {

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
        LazyRace<Data> lr = new LazyRace(() -> new Data());
        Data d = lr.get();
    }
}
