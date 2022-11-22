package com.tutorial;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class CreateStreamTest {
    @Test
    void testCreateEmptyOrSingleStream(){
        Stream<String> emptyStream = Stream.empty();

        Stream<String> oneStream = Stream.of("Bella");

        String data = null;
        Stream<String> emptyOrNotStream = Stream.ofNullable(data);
    }

    @Test
    void testCreateStreamFromArrays(){
       Stream<String> streamString = Stream.of("Bella","Rizky","Kharisma");
       streamString.forEach(value -> System.out.println(value));

       Stream<Integer> streamInteger = Stream.of(1,2,3,4,5,6,7);
       streamInteger.forEach(value -> System.out.println(value));

       Stream<String> stringArray = Arrays.stream(new String[]{"Bella", "Rizky","Kahrisma"});
       stringArray.forEach(value-> System.out.println(value));
    }

    @Test
    void testCreateStreamFromCollection(){
        Collection<String> collectionStream = List.of("Bella","Rizky","Kharisma");

        Stream<String> stringStream = collectionStream.stream();
        stringStream.forEach(value-> System.out.println(value));
    }

    @Test
    void testInfiniteStream(){
        Stream<String> stream1 = Stream.generate(() -> "Programmer zaman now");
       // stream1.forEach(System.out::println);

        Stream<Integer> stream2 = Stream.iterate(1,value -> value+1);
        stream2.forEach(System.out::println);
    }
}
