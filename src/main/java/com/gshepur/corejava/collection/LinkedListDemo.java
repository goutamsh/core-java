package com.gshepur.corejava.collection;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {
    public static void main(String[] args) {
        //Using List interface
        List<String> linkedList = new LinkedList<>(Arrays.asList("One", "Two", "Three", "Four"));

        //Using Deque interface
        Deque<String> dequeList = new LinkedList<>(Arrays.asList("Five", "Six", "Seven", "Eight"));
        System.out.println("List before adding Nine : "+dequeList);
        dequeList.add("Nine");
        System.out.println("List after adding Nine, before poll : "+dequeList);
        dequeList.poll();
        System.out.println("List after adding Nine, after poll : "+dequeList);

        String six = dequeList.peek();
        System.out.println(six);
        System.out.println("List after peek : "+dequeList);
    }
}
