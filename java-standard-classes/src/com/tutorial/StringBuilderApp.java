package com.tutorial;

import java.lang.StringBuilder;

public class StringBuilderApp {
    public static void main(String[] args) {

    StringBuilder builder = new StringBuilder();
    builder.append("Bella");
        System.out.println(builder.hashCode());
    builder.append(" ");
        System.out.println(builder.hashCode());
    builder.append("Risky");
    builder.append(" ");
    builder.append("Kharisma");

    String bella ="bella";
        System.out.println(bella.hashCode());
    String bella2 ="risky";
        System.out.println(bella2.hashCode());
        System.out.println(builder);
    }
}
