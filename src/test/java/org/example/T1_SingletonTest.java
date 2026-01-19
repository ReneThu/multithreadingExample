package org.example;

import com.vmlens.api.AllInterleavings;
import com.vmlens.api.Runner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class T1_SingletonTest {

    static final class NaiveSingleton {
        static NaiveSingleton instance;

        private NaiveSingleton() {
        }

        static NaiveSingleton getInstance() {
            if (instance == null) {
                instance = new NaiveSingleton();
            }
            return instance;
        }
    }

    @BeforeEach
    void reset() {
        NaiveSingleton.instance = null;
    }

    @Test
    void test() {
        try (var interleavings = new AllInterleavings("Singleton 1", true)) {
            while (interleavings.hasNext()) {
                Runner.runParallel(NaiveSingleton::getInstance, NaiveSingleton::getInstance);
            }
        }
    }
}
