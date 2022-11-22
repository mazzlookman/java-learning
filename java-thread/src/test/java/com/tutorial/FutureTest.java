package com.tutorial;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FutureTest {

    @Test
    void testFuture() throws InterruptedException, ExecutionException {

        var executor = Executors.newSingleThreadExecutor();

        Callable<String> callable = ()->{
          Thread.sleep(5000);
          return "Hi";
        };

        Future<String> future = executor.submit(callable);
        System.out.println("Selese Future");

        while (!future.isDone()){
            System.out.println("Waiting Future..");
            Thread.sleep(1000);
        }

        String value = future.get();
        System.out.println(value);
    }

    @Test
    void invokeAll() throws InterruptedException, ExecutionException {
        var executor = Executors.newFixedThreadPool(10);

        List<Callable<String>> callables = IntStream.range(1,11).mapToObj(value -> (Callable<String>) ()->{
            Thread.sleep(value * 500);
            return String.valueOf(value);
        }).collect(Collectors.toList());

        var futures = executor.invokeAll(callables);

        for (Future<String> stringFuture : futures){
            System.out.println(stringFuture);
        }
    }

    @Test
    void invokeAny() throws ExecutionException, InterruptedException {
        var executor = Executors.newFixedThreadPool(10);

        List<Callable<String>> callables = IntStream.range(1,11).mapToObj(value -> (Callable<String>) ()-> {
            Thread.sleep(value*500);
            return String.valueOf(value);
        }).collect(Collectors.toList());


        var futures = executor.invokeAny(callables);

        System.out.println(futures);
    }
























}
