package com.tutorial;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadLocalTest {

    @Test
    void threadLocal() throws InterruptedException {
        final var random = new Random();
        final var userService = new UserService();
        final var executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 50; i++) {
            var task = i;
            executor.execute(() -> {
                try {
                    userService.setUser("User-"+task);
                    Thread.sleep(random.nextInt(3000));
                    userService.doAction();
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            });
        }
        executor.awaitTermination(1, TimeUnit.HOURS);
    }
}
