package com.tutorial.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

public class InterfaceTest {

    @Test
    void testInterface(){

        Class<NameAble> nameAbleClass = NameAble.class;
        Class<Person> personClass = Person.class;

        System.out.println(nameAbleClass.isInterface());
        System.out.println(nameAbleClass.getSuperclass());

        System.out.println(personClass.getInterfaces());

    }

    @Test
    void testModifier(){

        Class<Person> personClass = Person.class;

        System.out.println(Modifier.isPublic(personClass.getModifiers()));
        System.out.println(Modifier.isFinal(personClass.getModifiers()));

    }

}
