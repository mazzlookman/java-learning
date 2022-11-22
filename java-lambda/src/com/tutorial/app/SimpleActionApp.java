package com.tutorial.app;

import com.tutorial.lambda.SimpleAction;

public class SimpleActionApp {

    public static void main(String[] args) {

//        SimpleAction simpleAction1 = new SimpleAction() {
//            @Override
//            public String action() {
//                return "Bella";
//            }
//        };
//
//        System.out.println(simpleAction1.action());
//
//        SimpleAction simpleAction2 = () -> {
//            return "Bella";
//        };
//
//        System.out.println(simpleAction2.action());

        SimpleAction simpleAction1 = (String value) -> {
            return "Hello" + value;
        };

        SimpleAction simpleAction2 = value -> {
            return "Hello" + value;
        };

        SimpleAction simpleAction3 = value -> "Hello" + value;

        SimpleAction simpleAction4 = name -> name;
        System.out.println(simpleAction4.action("Bella"));



    }

}
