package com.tutorial.apps;

import com.tutorial.util.ArrayHelper;

public class ArrayHelperApp {
    public static void main(String[] args) {
        String[] names = {"Bella","Risky","Kharisma"};
        Integer[] numbers = {1,2,3,4};

        System.out.println(
                ArrayHelper.count(names)
        );

        System.out.println(
                ArrayHelper.count(numbers)
        );
    }
}
