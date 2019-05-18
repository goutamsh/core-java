package com.gshepur.corejava.collection;

import java.util.*;

public class ArrayListDemo {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>(Arrays.asList("Apple", "Ball", "Cat", "Dog"));

        //Iterating using foreach
        System.out.println("Iterating using foreach");
        for (String s:stringList) {
            System.out.println(s);
            //Can't modify list while iterating throw ConcurrentModificationException
            //stringList.remove("Dog");
            //stringList.add("Elephant");
        }

        //Using Iterator
        System.out.println("Iterating using Iterator");
        Iterator<String> iterator = stringList.iterator();
        while (iterator.hasNext()){
            String str = iterator.next();
            System.out.println(str);
            if(str.equals("Ball")){
                //ConcurrentModificationException as list is modifying while iterating
                // stringList.remove("Ball");

                //using iterator element can be removed
                iterator.remove();

            }
        }

        //Using ListIterator
        System.out.println("Iterating using listIterator");
        ListIterator<String> listIterator = stringList.listIterator(stringList.size());
        while (listIterator.hasPrevious()){
            System.out.println(listIterator.previous());
        }
    }
}
