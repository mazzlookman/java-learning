package com.tutorial;

import org.junit.jupiter.api.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierTest {

    @Test
    void testCyclicBarrier() throws InterruptedException {
        final var cyclic = new CyclicBarrier(5);
        final var executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 4; i++) {
            executor.execute(() -> {
                try {
                    System.out.println("Waiting..");
                    cyclic.await();
                    System.out.println("Finished");
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.awaitTermination(1, TimeUnit.HOURS);
    }
}
