package com.tutorial;

import org.junit.jupiter.api.Test;

import java.util.List;

public class LazyEvaluationTest {

    @Test
    void testLazyOperation(){
        List<String> names = List.of("Otong","Ucup","Mariba");

        names.stream()
                .map(name -> {
                System.out.println("Change "+name+" to UpperCase");
                return name.toUpperCase();
        });
    }

    @Test
    void testTerminalOperation(){
        List<String> names = List.of("Otong","Ucup","Mariba");

        names.stream()
                .map(name -> {
                    System.out.println("Change "+name+" to UpperCase");
                    return name.toUpperCase();
                })
                .map(upper ->{
                    System.out.println("Change "+upper+" to Mr.");
                    return "Mr. "+upper;
                })
                .forEach(System.out::println);
    }
}
