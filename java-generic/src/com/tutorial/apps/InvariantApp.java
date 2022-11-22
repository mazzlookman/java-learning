package com.tutorial.apps;

import com.tutorial.MyData;

public class InvariantApp {
    public static void main(String[] args) {

        MyData<String> stringMyData = new MyData<>("Bella");
//        doIt(stringMyData); //Error
//        MyData<Object> objectMyData = stringMyData; //Error

        MyData<Object> objectMyData1 = new MyData<>(1000);
//        MyData<Integer> integerMyData = objectMyData1; // Error
//        doItInteger(objectMyData1);
    }

    public static void doIt(MyData<Object> objectMydata){
        // do nothing
    }

    public static void doItInteger(MyData<Integer> integerMyData){
        //do nothing
    }
}
