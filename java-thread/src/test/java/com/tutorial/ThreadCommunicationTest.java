package com.tutorial;

import org.junit.jupiter.api.Test;

public class ThreadCommunicationTest{
    private String message;
    @Test
    void manual() throws InterruptedException{
        var thread1 = new Thread(() -> {
           while (message == null){
               //wait
           }
            System.out.println(message);
        });

        var thread2 = new Thread(()->{
           message = "Bella Rizky Kharisma";
        });

        thread1.start();
        thread2.start();

        thread2.join();
        thread1.join();
    }

    @Test
    void waitNotify() throws InterruptedException {
        final var lock = new Object();

        var thread1 = new Thread(()->{
           synchronized (lock){
               try {
                   lock.wait();
                   System.out.println(message);
               } catch (InterruptedException exception) {
                   exception.printStackTrace();
               }
           }
        });

        var thread2 = new Thread(()->{
           synchronized (lock){
               message = "Bella Rizky Kharisma";
               lock.notify();
           }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
