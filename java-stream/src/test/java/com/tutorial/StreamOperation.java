package com.tutorial;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

public class StreamOperation {

    @Test
    void testStreamOperation(){
        List<String> names = List.of("Mohammad","Lukman","Aqib");
        Stream<String> streamNames = names.stream();
        Stream<String> namesUpper = streamNames.map(name -> name.toUpperCase());

        namesUpper.forEach(System.out::println);

        names.forEach(System.out::println);
    }
}
