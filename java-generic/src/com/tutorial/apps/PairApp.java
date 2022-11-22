package com.tutorial.apps;

import com.tutorial.Pair;

public class PairApp {
    public static void main(String[] args) {

        Pair<String, Integer> pair = new Pair<String, Integer>("Bella",2802);
        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());
    }
}
