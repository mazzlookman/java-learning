package com.tutorial;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentMapTest {

    @Test
    void concurrentMap() throws InterruptedException {
        final var countDown = new CountDownLatch(100);
        final var map = new ConcurrentHashMap<Integer, String>();
        final var executor = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 100; i++) {
            final var task = i;
            executor.execute(() -> {
                try {
                    Thread.sleep(500);
                    map.putIfAbsent(task,"Data-"+task);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }finally{
                    countDown.countDown();
                }
            });
        }

        executor.execute(() -> {
            try {
                countDown.await();
                map.forEach((integer, s) -> System.out.println(integer+" : "+s));
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        });

        executor.awaitTermination(1, TimeUnit.HOURS);
    }

    @Test
    void testCollection(){
        List<String> list = List.of("Mohammad","Lukman","Aqib");
        List<String> synchronizedList = Collections.synchronizedList(list);
        System.out.println(synchronizedList);
    }
}
