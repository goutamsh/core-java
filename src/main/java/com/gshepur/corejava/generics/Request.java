package com.gshepur.corejava.generics;

public class Request<T> {

    private T t;

    //static member of generic not allowed
    //private static T tstatic;

    //Can't create array of generic type
    //private T[] tArray = new T[2];


    public void set(T t){
        this.t = t;
        //instance of generic type can't be created
        //this.t = new T();
    }

    public T get(){
        return this.t;
    }
}
