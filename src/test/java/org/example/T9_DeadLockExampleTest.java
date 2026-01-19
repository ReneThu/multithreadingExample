package org.example;

import com.vmlens.api.AllInterleavings;
import com.vmlens.api.Runner;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;

public class T9_DeadLockExampleTest {

    private final Object lockA = new Object();
    private final Object lockB = new Object();

    void ab() {
        synchronized (lockA) {
            sleep(50);
            synchronized (lockB) {
                // unreachable when deadlocked
            }
        }
    }

    void ba() {
        synchronized (lockB) {
            sleep(50);
            synchronized (lockA) {
                // unreachable when deadlocked
            }
        }
    }

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Test
    @Disabled
    void always_deadlocks() throws Exception {
        T9_DeadLockExampleTest d = new T9_DeadLockExampleTest();
        CountDownLatch start = new CountDownLatch(1);

        Thread t1 = new Thread(() -> {
            await(start);
            d.ab();
        }, "t1");
        Thread t2 = new Thread(() -> {
            await(start);
            d.ba();
        }, "t2");

        t1.start();
        t2.start();
        start.countDown();

        t1.join();
        t2.join();
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

    private static void await(CountDownLatch latch) {
        try {
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
