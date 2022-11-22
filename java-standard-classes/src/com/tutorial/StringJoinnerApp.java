package com.tutorial;

import java.util.StringJoiner;

public class StringJoinnerApp {

    public static void main(String[] args) {

    StringJoiner joiner = new StringJoiner(", ","[","]");
    joiner.add("Bella");
    joiner.add("Rizky");
    joiner.add("Kharisma");

    String value = joiner.toString();
        System.out.println(value);
    }
}
