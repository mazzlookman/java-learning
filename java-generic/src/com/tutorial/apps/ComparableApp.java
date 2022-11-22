package com.tutorial.apps;

import com.tutorial.Person;

import java.util.Arrays;

public class ComparableApp {
    public static void main(String[] args) {

        Person[] people = {
                new Person("Hai", "Indonesia"),
                new Person("Juga", "Indonesia"),
                new Person("Kenapa", "Indonesia")
        };

        Arrays.sort(people);

        System.out.println(Arrays.toString(people));
    }
}
