package com.tutorial.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListApp {
    //ArrayList vs LinkedList
    //Sama-sama turunan interface List -> Collection
    //ArrayList lebih cepat saat set dan get data
    //LinkedList lebih cepat saat add dan remove data

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
//        List<String> strings1 = new LinkedList<>();

        strings.add("Bella");
        strings.add("Rizky");
        strings.add("Kharisma");

        strings.set(0,"Aqib");

        strings.remove(2);

        for (var value : strings){
            System.out.println(value);
        }
    }
}
