package org.example;

import com.vmlens.api.AllInterleavings;
import com.vmlens.api.Runner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//not correct
public class T7_SingletonTest {

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
        try (var interleavings = new AllInterleavings("Singleton 7", true)) {
            while (interleavings.hasNext()) {
                Runner.runParallel(
                        () -> {
                            var instance = new UnsafeLocalDCLFactory().getInstance();
                            Assertions.assertEquals(1, instance.x);
                        },
                        () -> {
                            var instance = new UnsafeLocalDCLFactory().getInstance();
                            Assertions.assertEquals(1, instance.x);
                        }
                );
            }
        }
    }
}
