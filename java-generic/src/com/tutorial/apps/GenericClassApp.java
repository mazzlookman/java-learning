package com.tutorial.apps;

import com.tutorial.MyData;

public class GenericClassApp {
    public static void main(String[] args) {

        MyData<String> stringData = new MyData<String>("Bella");
        MyData<Integer> integerData = new MyData<Integer>(123);

        String stringValue = stringData.getData();
        Integer integerValue = integerData.getData();

        System.out.println(stringValue);
        System.out.println(integerValue);
    }
}
