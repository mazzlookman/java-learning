package com.tutorial;

import java.util.Arrays;
import java.util.EnumMap;

public class ArraysApp {
    public static void main(String[] args) {
        int[] numbers = {
                1, 4, 234, 5, 6, 19, 5, 67, 4, 5, 67, 4, 6, 7
        };
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));

        System.out.println(Arrays.binarySearch(numbers,7));
        System.out.println(Arrays.binarySearch(numbers,6));
        System.out.println(Arrays.binarySearch(numbers,5));

        int[] result = Arrays.copyOf(numbers,numbers.length);
        int[] result2 = Arrays.copyOf(numbers,5);
        int[] result3 = Arrays.copyOfRange(numbers,2,7);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(result2));
        System.out.println(Arrays.toString(result3));


    }
}
