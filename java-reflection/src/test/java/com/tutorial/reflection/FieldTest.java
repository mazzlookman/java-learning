package com.tutorial.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

public class FieldTest {

    @Test
    void testField(){

        Class<Person> personClass = Person.class;

        Field[] fields = personClass.getDeclaredFields();

        for (var values : fields){
            System.out.println(values.getName()+" : "+values.getType().getName());
        }
    }

    @Test
    void testGetFieldValue() throws NoSuchFieldException, IllegalAccessException {

        Class<Person> personClass = Person.class;
        Field firstName = personClass.getDeclaredField("firstname");
        Field lastName = personClass.getDeclaredField("lastname");
        firstName.setAccessible(true);
        lastName.setAccessible(true);

        Person person1 = new Person("Bella","Kharisma");
        Object values1 = firstName.get(person1);
        Object values2 = lastName.get(person1);
        System.out.println(values1+" - "+values2);

        Person person2 = new Person("Aqib","Mohammad");
        Object value = lastName.get(person2);
        System.out.println(value);

    }

    @Test
    void testSetFieldValue() throws NoSuchFieldException, IllegalAccessException {

        Class<Person> personClass = Person.class;
        Field fieldFistName = personClass.getDeclaredField("firstname");
        fieldFistName.setAccessible(true);

        Person person1 = new Person("Aqib","Mohammad");
        System.out.println(person1.getFirstname());
        fieldFistName.set(person1,"Bella");
        System.out.println(person1.getFirstname());
    }
}
