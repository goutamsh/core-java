package com.gshepur.corejava.generics;

public interface KeyValueInterface<K,V> {
    void add(K key, V value);
    V get(K key);
    int size();
}
