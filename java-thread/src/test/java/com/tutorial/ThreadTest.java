package com.tutorial;

import org.junit.jupiter.api.Test;

public class ThreadTest {

    @Test
    void mainThread(){
        var name = Thread.currentThread().getName();
        System.out.println(name);
    }

    @Test
    void createThread(){
        Runnable runnable = () -> {
            System.out.println("Hello from thread: "+Thread.currentThread().getName());
        };

        var thread = new Thread(runnable);
        thread.start();

        System.out.println("program selesai");
    }

    @Test
    void threadSleep() throws InterruptedException{
        Runnable runnable = () -> {
            try{
                Thread.sleep(2000);
                System.out.println("Hello from thread : " + Thread.currentThread().getName());
            }catch (InterruptedException exception){
                exception.printStackTrace();
            }
        };

        var thread = new Thread(runnable);
        thread.start();

        Thread.sleep(3000);
        System.out.println("program selesai");
    }

    @Test
    void threadJoin() throws InterruptedException{
        Runnable runnable = () -> {
            try{
                Thread.sleep(2000);
                System.out.println("Hello from thread : " + Thread.currentThread().getName());
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        };

        var thread = new Thread(runnable);
        thread.start();
        System.out.println("Menunggu selesai");
        thread.join();
        System.out.println("program selesai");
    }

    @Test
    void threadInterrupt() throws InterruptedException{
        Runnable runnable = () -> {
            for (int i=0; i<10; i++){
//                if (Thread.interrupted()) {
//                    return;
//                }
                System.out.println("Runnable: "+i);

                try{
                    Thread.sleep(1000);

                }catch(InterruptedException e){
                    return;
                }
            }
        };

        var thread = new Thread(runnable);
        thread.start();
        Thread.sleep(6000);
        thread.interrupt();
        System.out.println("Menunggu selesai");
        thread.join();
        System.out.println("program selesai");
    }

    @Test
    void threadName(){
        var thread = new Thread(() -> {
            System.out.println("Run in thread: "+Thread.currentThread().getName());
        });
        thread.setName("Bella");
        thread.start();
    }

    @Test
    void threadState() throws InterruptedException {
        var thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getState());
            System.out.println("run in thread: "+Thread.currentThread().getName());
        });
        thread.setName("Bell");
        System.out.println(thread.getState());

        thread.start();
        thread.join();
        System.out.println(thread.getState());
    }

























}








































