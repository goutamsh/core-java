package com.gshepur.corejava.java8;

import java.util.Optional;
import java.util.stream.Stream;

public class LazyInvocationJava8Streams {

    private static int count;

    private static void incrementCount(){
        count++;
    }

    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("Mother", "Father", "Mother-in-law", "Father-in-law").filter(s -> {
            incrementCount();
            return s.contains("in-law");
        }).map(s->s+"appender");

        System.out.println("Before calling Terminal operation on stream count:"+count);
        Optional<String> first = stringStream.findFirst();
        System.out.println("After calling Terminal operation on stream count:"+count);
        System.out.println(first);


    }
}
