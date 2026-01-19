package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SingletonTests_three {

    //Not correct
    static final class NaiveSingleton {
        private static NaiveSingleton instance;
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
