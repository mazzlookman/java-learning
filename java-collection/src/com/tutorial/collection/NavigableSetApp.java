package com.tutorial.collection;

import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class NavigableSetApp {

    public static void main(String[] args) {
        NavigableSet<String> navigableSet = new TreeSet<>();

        navigableSet.addAll(Set.of("Bella","Rizky","Kharisma","Mohammad","Lukman","Aqib"));
        NavigableSet<String> nameReverse = navigableSet.descendingSet();

        NavigableSet<String> kharisma = navigableSet.tailSet("Kharisma",true);

        for (var values:kharisma){
            System.out.println(values);
        }

    }

}
