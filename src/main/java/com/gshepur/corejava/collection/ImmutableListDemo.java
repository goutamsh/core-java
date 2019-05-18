package com.gshepur.corejava.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ImmutableListDemo {

    public static void main(String[] args) {
        List<String> list = Collections.unmodifiableList(Arrays.asList("1","2", "3", "4"));
        //UnsupportedOperationException will be thrown as list is immutable
        list.add("5");

        //Google Guava and Apache Collection Commons library can be used for creating immutable lists also.
    }
}
