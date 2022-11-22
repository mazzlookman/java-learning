package com.tutorial.app;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class JavaUtilFunctionApp {
    public static void main(String[] args) {
        consumerClass();
        functionClass();
        predicateClass();
        supplierClass();
    }

    static void supplierClass(){
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "Bella Rizky Kharisma";
            }
        };

        Supplier<String> supplier1 = () -> supplier.get();

        System.out.println(supplier1.get());
    }

    static void predicateClass(){
        //Predicate<T> - method-nya return boolean
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.isBlank();
            }
        };

        Predicate<String> predicate1 = s -> s.isBlank();

        System.out.println(predicate1.test(""));
        System.out.println(predicate1.test("Bella"));
    }

    static void functionClass(){
        //Function - digunakan untuk inject data dengan parameter + return value data tersebut
        Function<String,Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };
        var values = function.apply("Bella");
        System.out.println(values);

        //lambda function
        Function<String,Integer> function1 = s -> s.length();
        System.out.println(function1.apply("Bella"));
    }

    static void consumerClass(){
        //Consumer - digunakan jika kita hanya butuh sebuah lambda yg hanya untuk menerima data
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        consumer.accept("Bella Cans");

        Consumer<String> consumer1 = s -> System.out.println(s);
        consumer.accept("Bella Cans");
    }

}
