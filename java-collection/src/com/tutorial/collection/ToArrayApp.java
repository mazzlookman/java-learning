package com.tutorial.collection;

import java.util.Arrays;
import java.util.List;

public class ToArrayApp {

    public static void main(String[] args) {
        List<String> list = List.of("Bella","Rizky","Kharisma");

        Object[] objects = list.toArray();
        String[] strings = list.toArray(new String[]{});

        System.out.println(Arrays.toString(objects));
        System.out.println(Arrays.toString(strings));
    }

}
