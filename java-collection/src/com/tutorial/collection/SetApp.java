package com.tutorial.collection;

import java.util.*;

public class SetApp {
    public static void main(String[] args) {
//        Set<String> set = new HashSet<>();

        Set<String> set = new LinkedHashSet<>();

        set.add("Bella");
        set.add("Rizky");
        set.add("Kharisma");

        set.add("Bella");
        set.add("Rizky");
        set.add("Kharisma");

        for (var values : set){
            System.out.println(values);
        }

        //immutable set
        Set<String> immutableSet1 = Collections.unmodifiableSet(set);
        System.out.println(immutableSet1);

       Set<String> immutableSet2 = Set.of("Bella","Rizky","Kharisma");
       //error UnsupportedOperationException
       immutableSet2.add("Aqib");
    }
}
