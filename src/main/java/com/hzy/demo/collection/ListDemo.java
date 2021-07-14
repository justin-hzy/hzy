package com.hzy.demo.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListDemo {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        Vector vector = new Vector();

        for (int i =0;i<100;i++){
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));

                System.out.println(list);
            },String.valueOf(i)).start();
        }

        /*CopyOnWriteArrayList copy = new CopyOnWriteArrayList();
        copy.add("");*/
    }
}
