package com.tutorial;

import org.junit.jupiter.api.Test;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
    @Test
    void delayedJob() throws InterruptedException{
        var task = new TimerTask(){
            @Override
            public void run() {
                System.out.println("Delayed job");
            }
        };

        var timer = new Timer();
        timer.schedule(task,2000);

        Thread.sleep(5000L);
    }

    @Test
    void periodicJob() throws InterruptedException{
        var task = new TimerTask(){
            @Override
            public void run() {
                System.out.println("Periodic job");
            }
        };

        var timer = new Timer();
        timer.schedule(task,2000,2000);

        Thread.sleep(10000);
    }
}
