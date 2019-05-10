package com.gshepur.corejava.java8streams.java8;

import java.util.Arrays;

public class Java8Streams {

    public static void main(String[] args) {

        String[] strings = new String[]{"Hello", "World", "Glasgow"};

        long count = Arrays.asList(strings).stream().peek(System.out::println).count();
        System.out.println(count);
    }
}
