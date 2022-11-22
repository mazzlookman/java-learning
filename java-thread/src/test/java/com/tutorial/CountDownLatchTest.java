package com.tutorial;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {

    @Test
    void testCountDownLatch() throws InterruptedException {
        final var countDownLatch = new CountDownLatch(5);
        final var executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 5; i++) {
            executor.execute(() -> {
                try {
                    System.out.println("start task");
                    Thread.sleep(1000);
                    System.out.println("end task");
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }finally {
                    countDownLatch.countDown();
//                    System.out.println("count");
                }
            });

            executor.execute(()->{
                try {
                    countDownLatch.await();
                    System.out.println("all task finished");
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            });
        }

        executor.awaitTermination(1, TimeUnit.HOURS);
    }
}
