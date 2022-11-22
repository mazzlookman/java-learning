package com.tutorial;

import org.junit.jupiter.api.Test;

import java.util.List;

public class StreamPipeline {

    @Test
    void testStreamPipeline(){
        List<String> names = List.of("Otong","Ucup","Mario");

            names.stream()
                .map(name -> name.toUpperCase())
                .map(upper -> "Mr. "+upper)
                .forEach(System.out::println);
    }
}
