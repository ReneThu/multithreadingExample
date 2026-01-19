package org.example;

import org.junit.jupiter.api.Test;

//somewhat correct
public class SingletonTests_eight {

    interface Factory {
        Singleton getInstance();
    }

    static final class Singleton {
        final int x;
        final int y;

        Singleton() {
            this.x = 1;
            this.y = 2;
        }
    }

    public class UnsafeLocalDCLFactory implements Factory {
        private Singleton instance;

        @Override
        public Singleton getInstance() {
            Singleton res = instance;
            if (res == null) {
                synchronized (this) {
                    res = instance;
                    if (res == null) {
                        res = new Singleton();
                        instance = res;
                    }
                }
            }
            return res;
        }
    }

    @Test
    void test() {
        //todo
    }
}
