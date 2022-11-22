package com.tutorial;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

public class OrderingOperation {

    @Test
    void testSorted(){
        List.of("Hai", "Bella", "Rizky", "Kharisma", "Lukman", "Aqib").stream()
                .sorted()
                .forEach(System.out::println);
    }

    @Test
    void testSortedWithComparator(){
        Comparator<String> comparator = Comparator.reverseOrder();
        List.of("Hai", "Bella", "Rizky", "Kharisma", "Lukman", "Aqib").stream()
                .sorted(comparator)
                .forEach(System.out::println);
    }
}
