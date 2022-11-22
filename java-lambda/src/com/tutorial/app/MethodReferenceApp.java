package com.tutorial.app;

import com.tutorial.util.StringUtil;

import java.util.function.Function;
import java.util.function.Predicate;

public class MethodReferenceApp {

    public static void main(String[] args) {

        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return StringUtil.isLowerCase(s);
            }
        };

        //Method Reference
        //Semua ciri2 method di util class & lambda class harus sama, mulai dari return, tipe data + jumlah parameter

        Predicate<String> predicate1 = StringUtil::isLowerCase;

        System.out.println(predicate1.test("bella"));
        System.out.println(predicate1.test("Bella"));

        run1();

    }

    public static void run1(){
        //MethodReference object orang lain
        MethodReferenceApp methodReferenceApp = new MethodReferenceApp();
        Predicate<String> predicate1 = methodReferenceApp::isLowerCase;

        System.out.println(predicate1.test("bella"));

        //MethodReference untuk method-nya punyanya tipe data parameter
        Function<String, String> function = new Function<String, String>() {
            @Override
            public String apply(String value) {
                return value.toUpperCase();
            }
        };

        Function<String, String> function1 = String::toUpperCase;
        System.out.println(function1.apply("bella"));
    }

    void run(){
        //MethodReference non-static
        Predicate<String> predicate = this::isLowerCase;

        System.out.println(predicate.test("bella"));

    }


    public boolean isLowerCase(String value){

        for(var c : value.toCharArray()){
            if (!Character.isLowerCase(c)){
                return false;
            }
        }
        return true;
    }
}
