package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


//Maybe drop this and just add volatile in the example
class SingletonTests_four {

    //correct
    static final class NaiveSingleton {
        private static volatile NaiveSingleton instance;
        private static NaiveSingleton getInstance() {
            if (instance == null) {
                synchronized (NaiveSingleton .class) {
                    if (instance == null) {
                        instance = new NaiveSingleton();
                    }
                }
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
        //TODO
    }
}
