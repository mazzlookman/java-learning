package com.tutorial.collection;

import com.tutorial.data.Person;
import com.tutorial.data.PersonComparator;

import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetApp {
    public static void main(String[] args) {
//        SortedSet<Person> person = new TreeSet<>(new PersonComparator().reversed());
//
//        person.add(new Person("Bella"));
//        person.add(new Person("Rizky"));
//        person.add(new Person("Kharisma"));

        SortedSet<String> person = new TreeSet<>();

        person.add("Kharisma");
        person.add("Rizky");
        person.add("Bella");

        for (var values : person){
            System.out.println(values);
        }
    }
}
