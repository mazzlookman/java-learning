package com.tutorial;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

public class TerminationOperationTest {

    @Test
    void testMap(){
        List.of("Otong","Ucup","Mariba").stream()
                .map(names -> names.toUpperCase())
                .map(upper -> upper + upper.length() +"\n")
                .map(value -> value + value + value)
                .forEach(length -> System.out.println(length));
    }

    @Test
    void testFlatMap(){
        List.of("Otong","Ucup","Mariba").stream()
                .map(name -> name.toUpperCase())
                .flatMap(upper -> Stream.of(upper, upper.length()))
                .flatMap(value -> Stream.of(value, value, value))
                .forEach(System.out::println);
    }
}
