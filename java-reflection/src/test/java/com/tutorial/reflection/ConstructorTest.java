package com.tutorial.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;

public class ConstructorTest {

    @Test
    void testConstructor(){

        Class<Person> personClass = Person.class;

        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();

        for (Constructor<?> declaredConstructor : declaredConstructors) {

            System.out.println(declaredConstructor.getName());

            Parameter[] parameters = declaredConstructor.getParameters();

            for (Parameter parameter : parameters) {

                System.out.println(parameter.getName());
                System.out.println(parameter.getType());

            }

        }
    }

    @Test
    void testCreateObjectWithConstrustor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Person> personClass = Person.class;

        Constructor<Person> emptyCons = personClass.getConstructor();
        Constructor<Person> withParam = personClass.getConstructor(String.class,String.class);

        Person person1 = emptyCons.newInstance();
        Person person2 = withParam.newInstance("Bella","Kharisma");

        System.out.println(person1);
        System.out.println(person2);
    }
}