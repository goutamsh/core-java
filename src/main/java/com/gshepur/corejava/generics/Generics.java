package com.gshepur.corejava.generics;

import java.util.Arrays;
import java.util.List;

public class Generics {

    public static void main(String[] args) {

        //Example of Generics method
        int countOfOccurrence = findCountOfOccurrence(new String[]{"1", "2", "3", "4", "5", "2", "2"}, "2");
        System.out.println(countOfOccurrence);

        int countOfOccurrence2 = findCountOfOccurrence(new Integer[]{1, 2, 3, 4, 5, 2, 2,2}, 2);
        System.out.println(countOfOccurrence2);


        //Generics Class
        Request<String> stringRequest = new Request<>();
        stringRequest.set("Glasgow");
        System.out.println(stringRequest.get());

        Request<Integer> numberRequest = new Request<>();
        numberRequest.set(400);
        int val = numberRequest.get();
        System.out.println(val);


        //Generic interface
        KeyValueInterface<String, Integer> stringIntegerKeyValue = new KeyValueImpl<>();
        stringIntegerKeyValue.add("hello", 1);
        stringIntegerKeyValue.add("world", 2);
        System.out.println(stringIntegerKeyValue.get("hello") + " "+ stringIntegerKeyValue.get("world") + " Size :"+stringIntegerKeyValue.size());


        //Bounder Generics
        //Upper bound look like this <? extends T>
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        System.out.println(sum(integers));

        List<Double> doubles = Arrays.asList(1.5d, 2d);
        System.out.println(sum(doubles));

        //Lower bound looks like thi List<? super GrandChildClass>

        //What is not allowed in Generics
        //1. You can’t have static field of type

        //2. You can not create an instance of T



    }

    public static <T> int findCountOfOccurrence(T[] array, T item){
        int count = 0;
        if(item == null){
            for (T t: array) {
                if(t == null){
                    count++;
                }
            }
        }else{
            for (T t : array){
                if(t.equals(item)){
                    count++;
                }
            }
        }
        return count;
    }

    private static Number sum(List<? extends Number> numbers){
        double sum = 0.0;
        for (Number number : numbers){
            sum += number.doubleValue();
        }
        //Can;t add anything to list
        //numbers.add(2d);
        return sum;
    }

}

