package com.tutorial;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

public class AgregateOperation {

    @Test
    void testAgregateOperation(){
        List<String> list = List.of("Hai", "Bella", "Rizky", "Kharisma", "Lukman", "Aqib");

        list.stream().max(Comparator.naturalOrder()).ifPresent(System.out::println);
        list.stream().min(Comparator.naturalOrder()).ifPresent(System.out::println);
        long count = list.stream().count();
        System.out.println(count);
    }

    @Test
    void testReduce(){
        var sum = List.of (1, 2, 3, 4, 5).stream()
                .reduce(0, (value,item) -> value + item);
        System.out.println(sum);

        var factorial = List.of (1, 2, 3, 4, 5).stream()
                .reduce(1, (value, item) -> value * item);
        System.out.println(factorial);
    }
}
