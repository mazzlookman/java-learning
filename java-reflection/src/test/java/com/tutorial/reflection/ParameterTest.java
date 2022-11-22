package com.tutorial.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ParameterTest {

    @Test
    void testParameters(){

        Class<Person> personClass = Person.class;

        Method[] methods = personClass.getDeclaredMethods();

        for (Method method : methods) {
            Parameter[] parameters = method.getParameters();
            System.out.println(method.getName());
            for (Parameter parameter : parameters) {
                System.out.println("Parameter Name: "+parameter.getName());
                System.out.println("Parameter Type: "+parameter.getType());
            }

            System.out.println("==============================");
        }
    }

    @Test
    void testInvokeParameter() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Class<Person> personClass = Person.class;

        Method method = personClass.getDeclaredMethod("setFirstname", String.class);

        Person person = new Person("Bella","Kharisma");
        method.invoke(person,"Aqib");
        System.out.println(person.getFirstname());

    }
}
