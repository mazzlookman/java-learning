package com.tutorial.reflection;

import org.junit.jupiter.api.Test;

public class SuperClassTest {

    @Test
    void testSuperClass(){

        Class<Person> personClass = Person.class;

        Class<? super Person> superclass = personClass.getSuperclass();

        Class<? super Person> superclassTop = superclass.getSuperclass();

        System.out.println(personClass);
        System.out.println(superclass);
        System.out.println(superclassTop);



    }
}
