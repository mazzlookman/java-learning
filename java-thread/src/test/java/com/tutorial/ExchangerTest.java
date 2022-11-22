package com.tutorial;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Exchanger;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExchangerTest {

    @Test
    void testExchanger() throws InterruptedException {
        final var exchanger = new Exchanger<String>();
        final var executor  = Executors.newFixedThreadPool(10);

        executor.execute(() -> {
            try {
                System.out.println("Thread 1 send data: First");
                Thread.sleep(1000);
                var result = exchanger.exchange("First");
                System.out.println("Thread 1 receive data: "+result);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        });

        executor.execute(() -> {
            try {
                System.out.println("Thread 2 send data: Second");
                Thread.sleep(2000);
                var result = exchanger.exchange("Second");
                System.out.println("Thread 2 receive data: "+result);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        });

        executor.awaitTermination(1, TimeUnit.HOURS);
    }
}
