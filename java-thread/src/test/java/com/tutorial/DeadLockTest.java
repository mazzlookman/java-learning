package com.tutorial;

import org.junit.jupiter.api.Test;

public class DeadLockTest {

    @Test
    void transfer() throws InterruptedException {
        var balance1 = new Balance(1_000_000L);
        var balance2 = new Balance(1_000_000L);

        var thread1 = new Thread(() -> {
            try {
                Balance.transfer(balance1, balance2,300_000L);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        });

        var thread2 = new Thread(() -> {
            try {
                Balance.transfer(balance2, balance1,500_000L);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("balance1: "+balance1.getValue());
        System.out.println("balance2: "+balance2.getValue());
    }
}
