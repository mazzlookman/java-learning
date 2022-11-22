package com.tutorial;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ScheduleExecutorTest {

    @Test
    void testDelayed() throws InterruptedException {
        var executor = Executors.newScheduledThreadPool(10);

        var schedule = executor.schedule(() -> System.out.println("Delayed task"),2, TimeUnit.SECONDS);

        System.out.println(schedule.getDelay(TimeUnit.MILLISECONDS));

        executor.awaitTermination(1,TimeUnit.MINUTES);

    }


}
