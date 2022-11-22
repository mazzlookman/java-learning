package com.tutorial.collection;

import java.util.*;

public class MapApp {

    public static void main(String[] args) {
        enumMap();
    }

    public static void hashMap() {
        Map<String, String> name = new LinkedHashMap<>();

        name.put("first_name", "Bella");
        name.put("second_name", "Rizky");
        name.put("last_name", "Kharisma");

        for (var values : name.keySet()) {
            System.out.println(name.get(values));
        }
    }

    public static void weakHashMap(){
        Map<Integer, Integer> map = new WeakHashMap<>();

        for (int i = 0; i < 1_000_000; i++) {
            map.put(i, i);
        }

        System.gc();

        System.out.println(map.size());
    }

    public static void linkedHashMap(){
        Map<String, String> map = new LinkedHashMap<>();
        map.put("last","otong");
        map.put("first","otong");
        map.put("middle","otong");

        for (var values : map.keySet()){
            System.out.println(values);
        }
    }

    public static enum Level{
        FREE, LOW, MEDIUM, VIP
    }

    public static void enumMap() {
        Map<Level, String> map = new EnumMap<Level, String>(Level.class);
        map.put(Level.FREE, "Aqib");
        map.put(Level.VIP, "Mohammad");

        for (var values : map.keySet()) {
            System.out.println(map.get(values));
        }

    }
}
