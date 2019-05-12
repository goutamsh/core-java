package com.gshepur.corejava.java8;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8Streams {

    public static void main(String[] args) {

        //Creating Empty Stream
        Stream<String> emptySteam = Stream.empty();

        //Stream created with Collection
        Collection<String> collection = Arrays.asList("a","b","c");
        Stream<String> streamOfCollection = collection.stream();

        //Creating Stream out of arrays
        Stream<String> streamFromArray = Stream.of("a", "b", "c");

        String[] stringArray = new String[]{"a", "b", "c"};
        Stream<String> streamFromArray2 = Arrays.stream(stringArray);

        //Using Stream builder
        Stream<String> streamOfCities = Stream.<String>builder().add("Glasgow").add("Edinburgh").add("London").build();
        System.out.println();
        //Stream with generators, creates infinite stream
        Stream.generate(()->Math.random()).limit(4).forEach(System.out::println);

        System.out.println();

        //Creating infinite stream with iterate
        Stream.iterate(2,i->i+2).limit(5).forEach(System.out::println);


        System.out.println();
        //Stream of primitives
        IntStream intStream = IntStream.of(10,20,30);
        intStream.forEach(System.out::println);

        System.out.println();
        //String can used as source of stream
        IntStream charStream = "Good Morning".chars();
        charStream.forEach((a)->System.out.println((char)a));


        //Stream of file - every line of file becomes element of Stream
        try {
            Path path = Paths.get(ClassLoader.getSystemResource("stream_file.txt").toURI());
            Stream<String> lines = Files.lines(path);
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }


        //Java 8 streams can’t be reused - Once terminal operation is executed, stream becomes inaccessible
        Stream<String> stringStream = Stream.of("Flower", "Book", "Pen").filter(e -> e.startsWith("B"));
        //Below call one will be successful
        System.out.println(stringStream.findAny());
        try{
            //Trying to reuse stream - so runtime exception
            System.out.println(stringStream.findAny());
        }catch (IllegalStateException e){
            System.out.println("IllegalStateException trying to reuse streams");
        }


        //Using collect() method
        List<String> collect = Stream.of("one", "two", "three").filter(s -> s.startsWith("o")).collect(Collectors.toList());
        System.out.println(collect);

        //Using joining of Collectors
        String joinedString = Stream.of("TV","Mobile","Laptop").collect(Collectors.joining(",", "(", ")"));
        System.out.println(joinedString);

        //Using GroupBy
        Map<Integer, List<String>> collect1 = Stream.of("tea", "cup", "door", "team").collect(Collectors.groupingBy(String::length));
        System.out.println(collect1);

        //parallel Streams
        Stream<String> parallelStream = Arrays.asList("John", "Paul", "Bob").parallelStream();
        System.out.println(parallelStream.isParallel());
        System.out.println(parallelStream.map(String::length).collect(Collectors.toList()));

    }
}
