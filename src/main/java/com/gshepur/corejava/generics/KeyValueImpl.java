package com.gshepur.corejava.generics;

import java.util.HashMap;
import java.util.Map;

public class KeyValueImpl<K,V> implements KeyValueInterface<K,V> {

    Map<K,V> map = new HashMap<>();

    @Override
    public void add(K key, V value) {
        map.put(key, value);
    }

    @Override
    public V get(K key) {
        return map.get(key);
    }

    @Override
    public int size() {
        return map.size();
    }

}
