package com.hzy.demo.collection;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LinkedHashMapDemo {

    public static void main(String[] args) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("msg1","s201");
        linkedHashMap.put("msg2","80808091283");
        linkedHashMap.put("msg3","adfzxcdf1");
        linkedHashMap.put("msg4","adsf1e5rvvhgfjhmj,;l```");

        Iterator iterator = linkedHashMap.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry.getValue());
        }

    }
}
