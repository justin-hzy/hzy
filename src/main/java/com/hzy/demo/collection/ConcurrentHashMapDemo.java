package com.hzy.demo.collection;


import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class ConcurrentHashMapDemo {

    public static void main(String[] args) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

        concurrentHashMap.put("","");

        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();

        copyOnWriteArraySet.addAll(new ArrayList());
    }
}
