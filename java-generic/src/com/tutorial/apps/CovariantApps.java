package com.tutorial.apps;

import com.tutorial.MyData;

public class CovariantApps {
    public static void main(String[] args) {

    MyData<String> data = new MyData<>("Bella");
    process(data);

    }

    public static void process(MyData<? extends Object> myData){
        System.out.println(myData.getData());

        // myData.setData(1); tidak boleh, bahaya
    }
}

