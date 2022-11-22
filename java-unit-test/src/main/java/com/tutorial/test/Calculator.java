package com.tutorial.test;

public class Calculator {

    public Integer divide(Integer a, Integer b){
        if (b == 0){
            throw new IllegalArgumentException("Can't divide by zero");
        }
        else {
            return a/b;
        }
    }
    public Integer add(Integer first, Integer second){
        return first+second;
    }
}
