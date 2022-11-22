package com.tutorial;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class StreamBuilder {

    @Test
    void testStreamBuilder(){
        Stream.Builder<String> builder = Stream.builder();
        builder.accept("Mohammad");
        builder.add("Lukman").add("Aqib");

        Stream<String> stream = builder.build();
        stream.forEach(System.out::println);
    }

    @Test
    void testStreamBuilderSimplify(){
        Stream<Object> stream = Stream.builder()
                .add("Mohammad").add("Lukman").add("Aqib").build();
        stream.forEach(System.out::println);
    }
}
