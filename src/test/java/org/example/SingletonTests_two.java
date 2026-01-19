package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SingletonTests_two {

    //Correct
    static final class NaiveSingleton {
        static NaiveSingleton instance;

        static synchronized NaiveSingleton getInstance() {
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
