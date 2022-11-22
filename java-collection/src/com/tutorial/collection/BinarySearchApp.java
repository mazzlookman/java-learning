package com.tutorial.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BinarySearchApp {

    public static void main(String[] args) {
        binarySearch();
    }

    public static void binarySearch(){
        List<Integer> number = new ArrayList<>(1000);

        for (int i = 1; i <= 1000; i++) {
            number.add(i);
        }

        int binarySearch = Collections.binarySearch(number, 333);
        System.out.println(binarySearch);

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        };

        int binarySearch2 = Collections.binarySearch(number,333);
        System.out.println(binarySearch2);
    }
}
