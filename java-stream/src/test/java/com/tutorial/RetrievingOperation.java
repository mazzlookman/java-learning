package com.tutorial;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class RetrievingOperation {

    @Test
    void testRetrievingOperation() {
        List<String> names = List.of("Hai", "Bella", "Rizky", "Kharisma", "Lukman", "Aqib");
        //names.stream().limit(2).forEach(System.out::println);
        //names.stream().skip(2).forEach(System.out::println);
//        names.stream().takeWhile(name -> name.length() <=5 ).forEach(System.out::println);
        names.stream().dropWhile(name -> name.length() <= 5).forEach(System.out::println);
    }

    @Test
    void testSingleRetrievingOperation() {
        Optional<String> optional = List.of("Hai", "Bella", "Rizky", "Kharisma", "Lukman", "Aqib")
                .stream().findAny();
        optional.ifPresent(name -> System.out.println(name));

        optional.stream().findFirst().ifPresent(name -> System.out.println(name));

    }
}

