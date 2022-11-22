package com.tutorial.reflection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ClassTest {

    @Test
    void testClass() throws ClassNotFoundException {

        Class<Person> personClass1 = Person.class;

        Class<?> personClass2 = Class.forName("com.tutorial.reflection.Person");

        Person person = new Person();
        Class<? extends Person> personClass3 = person.getClass();

    }

    @Test
    void testClassMethod(){

        Class<Person> personClass = Person.class;

        System.out.println(personClass.getSuperclass());
        System.out.println(Arrays.toString(personClass.getInterfaces()));
        System.out.println(Arrays.toString(personClass.getDeclaredConstructors()));
        System.out.println(Arrays.toString(personClass.getDeclaredMethods()));
        System.out.println(Arrays.toString(personClass.getDeclaredFields()));
        System.out.println(personClass.getModifiers());
        System.out.println(personClass.getPackage());
        System.out.println(personClass.getName());
        System.out.println(personClass.getSimpleName());
    }
}
