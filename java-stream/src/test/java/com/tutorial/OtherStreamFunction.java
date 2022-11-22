package com.tutorial;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.*;

public class OtherStreamFunction {
    List<String> listNames = List.of("Hai", "Bella", "Rizky", "Kharisma", "Lukman", "Aqib");
    //List<Integer> listNumbers = List.of(1,2,3,4,5,6,77,7,8,9);

    Stream<String> getStream(){
        return Stream.of("Hai", "Bella", "Rizky", "Kharisma","Aqib");
    }

    @Test
    void testStreamMatch(){
        boolean anyMatch = listNames.stream().anyMatch(value -> value.length() > 8);
        System.out.println(anyMatch);

        boolean allMatch = listNames.stream().allMatch(value -> value.isBlank());
        System.out.println(allMatch);

        boolean noneMatch = listNames.stream().noneMatch(value -> value.equals(value.toUpperCase()));
        System.out.println(noneMatch);
    }

    @Test
    void testStreamPeek(){
        listNames.stream()
                .peek(before -> System.out.println("Original: "+before))
                .map(name -> name.toUpperCase())
                .peek(upper -> System.out.println("Change Upper: "+upper))
                .forEach(System.out::println);
    }

    @Test
    void testPrimitiveStream(){
        IntStream intStream = IntStream.range(1,100);
        //intStream.forEach(System.out::println);

        LongStream longStream = LongStream.range(1,50);

        DoubleStream doubleStream = DoubleStream.builder().add(0.2).add(0.5).build();

        //Operation
        OptionalDouble optionalDouble = intStream.average();
        optionalDouble.ifPresent(System.out::println);

        IntStream.range(1,10)
                .mapToObj(number -> "Number: "+number)
                .forEach(System.out::println);

        IntStream.range(1,10)
                .mapToObj(number -> "Number: "+number)
                .forEach(System.out::println);

    }

    @Test
    void testStreamCollestors(){

        Set<String> set = getStream().collect(Collectors.toSet());
        System.out.println(set);
        Set<String> immutableSet = getStream().collect(Collectors.toUnmodifiableSet());
        System.out.println(immutableSet);

        List<String> list = getStream().collect(Collectors.toList());
        System.out.println(list);
        List<String> unmodifiedList = getStream().collect(Collectors.toUnmodifiableList());
        System.out.println(unmodifiedList);

        Map<String, Integer> map = getStream().collect(Collectors.toMap(key -> key, value -> value.length()));
        System.out.println(map);
        Map<String, Integer> unmodifiedMap = getStream().collect(Collectors.toUnmodifiableMap(key -> key, value -> value.length()));
        System.out.println(unmodifiedMap);

    }

    @Test
    void testCollectorsGroupingBy(){
        Map<String, List<Integer>> collect = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 11)
                .collect(Collectors.groupingBy(number -> {
                    if (number > 5){
                        return "Besar";
                    }else {
                        return "Kecil";
                    }
                }));
        System.out.println(collect);

        Map<String, List<String>> collect2 = getStream().collect(Collectors.groupingBy(
                name -> name.length() > 4 ? "Besar" : "Kecil"
        ));
        System.out.println(collect2);
    }

    @Test
    void testCollectorsPartitioningBy(){
       Map<Boolean, List<String>> partitioningBy =  getStream().collect(Collectors.partitioningBy(
               name -> name.length() > 4 ? false : true
        ));
        System.out.println(partitioningBy);
    }

    @Test
    void testParallelStream(){
        //Sequential - Berurutan
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .forEach(number -> {
                    //System.out.println(Thread.currentThread().getName()+": "+number);
                });

        //Parallel pake Thread
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).parallel()
                .forEach(number -> {
                    System.out.println(Thread.currentThread().getName()+": "+number);
                });

    }








































}





















