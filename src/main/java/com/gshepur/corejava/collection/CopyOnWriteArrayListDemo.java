package com.gshepur.corejava.collection;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>(Arrays.asList("A","B", "C", "D"));

        //Using Iterator
        System.out.println("Iterating using Iterator");
        Iterator<String> iterator = copyOnWriteArrayList.iterator();
        while (iterator.hasNext()){
            String str = iterator.next();
            System.out.println(str);
            if(str.equals("B")){
                //No ConcurrentModificationException thrown even after list is modifying while iterating
                copyOnWriteArrayList.remove("B");
                copyOnWriteArrayList.add("E");
                //CopyOnWriteArrayList iterator doesnt support remove method
                //iterator.remove();

            }
        }

        System.out.println("CopyOnWriteArrayList : "+copyOnWriteArrayList);

        System.out.println("CopyOnWriteArrayList with new iterator : ");
        Iterator<String> iterator2 = copyOnWriteArrayList.iterator();
        while (iterator2.hasNext()){
            String str = iterator2.next();
            System.out.println(str);
        }
    }
}
