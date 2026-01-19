package org.example;

import org.junit.jupiter.api.Test;

//not correct
public class SingletonTests_seven {

    interface Factory {
        Singleton getInstance();
    }

    static final class Singleton {
        int x;
        int y;

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
