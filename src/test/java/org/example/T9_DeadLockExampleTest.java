package org.example;

import com.vmlens.api.AllInterleavings;
import com.vmlens.api.Runner;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class T9_DeadLockExampleTest {

    private final Object lockA = new Object();
    private final Object lockB = new Object();

    void ab() {
        synchronized (lockA) {
            synchronized (lockB) {
                // unreachable when deadlocked
            }
        }
    }

    void ba() {
        synchronized (lockB) {
            synchronized (lockA) {
                // unreachable when deadlocked
            }
        }
    }

    @Test
    @Disabled
    void test() {
        try (var interleavings = new AllInterleavings("Deadlock", true)) {
            while (interleavings.hasNext()) {
                Runner.runParallel(
                        this::ab,
                        this::ba
                );
            }
        }
    }
}
