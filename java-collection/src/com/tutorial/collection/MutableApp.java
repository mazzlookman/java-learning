package com.tutorial.collection;

import com.tutorial.data.Person;

import java.util.List;

public class MutableApp {

    public static void main(String[] args) {

        Person person = new Person("Aqib");

        person.addHobby("game");
        person.addHobby("coding");

        doSomethingWithHobbies(person.getHobbies());

        for (var value : person.getHobbies()){
            System.out.println(value);
        }

    }

    public static void doSomethingWithHobbies(List<String> hobbi){
        hobbi.add("Bukan hobi");
    }
}
