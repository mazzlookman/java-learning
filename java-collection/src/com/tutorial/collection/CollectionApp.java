package com.tutorial.collection;

import java.util.*;

public class CollectionApp {

    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();

        collection.add("Bella");
        collection.add("Rizky");
        collection.add("Kharisma");
        collection.addAll(List.of("Mohammad","Lukman","Aqib"));

        collection.remove("Aqib");
        collection.removeAll(List.of("Lukman","Rizky"));

        collection.contains("value");
        collection.containsAll(List.of("value1","value2","dst"));

        for(var names:collection){
            System.out.println(names);
        }


    }

}
