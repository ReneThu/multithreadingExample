package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SingletonTests_one {

    //Not correct
    static final class NaiveSingleton {
        static NaiveSingleton instance;

        private NaiveSingleton() {}

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
        //TODO
    }
}
