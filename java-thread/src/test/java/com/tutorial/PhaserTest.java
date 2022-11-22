package com.tutorial;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class PhaserTest {
    @Test
    void countDownLatch() throws InterruptedException {
        final var phaser = new Phaser();
        final var executor = Executors.newFixedThreadPool(10);

        phaser.bulkRegister(5);

        for (int i = 0; i < 5; i++) {
            executor.execute(() -> {
                try {
                    System.out.println("start task");
                    Thread.sleep(1000);
                    System.out.println("end task");
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }finally {
                    phaser.arrive();
                }
            });

            executor.execute(() -> {
                phaser.awaitAdvance(0);
                System.out.println("all task finished");
            });
        }

        executor.awaitTermination(1, TimeUnit.HOURS);
    }

    @Test
    void cyclicBarrier() throws InterruptedException {
        final var phaser = new Phaser();
        final var executor = Executors.newFixedThreadPool(10);

        phaser.bulkRegister(5);

        for (int i = 0; i < 4; i++) {
            executor.execute(() -> {
                phaser.arriveAndAwaitAdvance();
                System.out.println("lomba dimulai");
            });
        }

        executor.awaitTermination(1,TimeUnit.HOURS);
    }
}
