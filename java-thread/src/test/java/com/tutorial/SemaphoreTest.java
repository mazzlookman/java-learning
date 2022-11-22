package com.tutorial;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {

    @Test
    void testSemaphore() throws InterruptedException {

        final var semaphore = new Semaphore(1);
        final var executor = Executors.newFixedThreadPool(100);

            for (int i = 0; i < 1000; i++) {
                executor.execute(() -> {
                    try {
                        semaphore.acquire();
                        Thread.sleep(1000);
                        System.out.println("Finish " + Thread.currentThread().getName());
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                    } finally {
                        semaphore.release();
                    }
                });
            }
        executor.awaitTermination(1, TimeUnit.HOURS);
    }

    @Test
    void test() throws InterruptedException {

        final var semaphore = new Semaphore(10);
        final var executor = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 1000; i++) {
            executor.execute(() -> {
                try {
                    semaphore.acquire();
                    Thread.sleep(1000);
                    System.out.println("Finish "+Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            });
        }

        executor.awaitTermination(1, TimeUnit.DAYS);

    }
}