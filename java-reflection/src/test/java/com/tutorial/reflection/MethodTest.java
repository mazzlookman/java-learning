package com.tutorial.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MethodTest {

    @Test
    void testGetMethods(){

        Class<Person> personClass = Person.class;
        Method[] methods = personClass.getDeclaredMethods();

        for (Method method : methods){
            System.out.println("Name: "+method.getName());
            System.out.println("Return type: "+method.getReturnType());
            System.out.println("Parameter Type: "+Arrays.toString(method.getParameterTypes()));
            System.out.println("Exception Type: "+Arrays.toString(method.getExceptionTypes()));
            System.out.println("================================");
        }
    }

    @Test
    void testGetMethodValue() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        Class<Person> personClass = Person.class;
        Method getFirstname = personClass.getDeclaredMethod("getFirstname");

        Person person = new Person("Bella","Kharisma");
        Object firstName = getFirstname.invoke(person);
        System.out.println(firstName);

    }
}
