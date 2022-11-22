package com.tutorial;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.RejectedExecutionHandler;

public class ThreadPoolTest {

    @Test
    void create() throws InterruptedException {
        var minThread = 10;
        var maxThread = 100;
        var alive = 1;
        var aliveTime = TimeUnit.MINUTES;
        var queue = new ArrayBlockingQueue<Runnable>(100);

        var executor = new ThreadPoolExecutor(minThread, maxThread, alive, aliveTime, queue);

        Runnable runnable = () -> {
            try {
                Thread.sleep(5000);
                System.out.println("Runnable from thread: " + Thread.currentThread().getName());
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        };

        executor.execute(runnable);

        Thread.sleep(6000);
    }

    @Test
    void rejected() throws InterruptedException {
        var minThread = 10;
        var maxThread = 100;
        var alive = 1;
        var aliveTime = TimeUnit.MINUTES;
        var queue = new ArrayBlockingQueue<Runnable>(10);
        var rejectedHandler = new LogRejectedExecutionHandler();

        var executor = new ThreadPoolExecutor(minThread, maxThread, alive, aliveTime, queue, rejectedHandler);

        for (int i = 0; i < 1000; i++) {
            final var task = i;
            Runnable runnable = () -> {
                try {
                    Thread.sleep(1000);
                    System.out.println("task " + task + " from thread: " + Thread.currentThread().getName());
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            };

            executor.execute(runnable);
        }
        executor.shutdownNow();
        executor.shutdown();
        executor.awaitTermination(1,TimeUnit.MINUTES);
    }

    public static class LogRejectedExecutionHandler implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("task " + r + " is rejected");
        }
    }
}
























