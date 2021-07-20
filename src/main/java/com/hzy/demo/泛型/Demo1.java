package com.hzy.demo.泛型;

public class Demo1 {

    public static void main(String[] args) {
        POJO1<String> pojo1 = new POJO1<>("aa");
        pojo1.setT("123");
        System.out.println(pojo1.getT());

        POJO1<Integer> pojo1_2 = new POJO1<>(122);
        pojo1_2.setT(123);
        System.out.println(pojo1_2.getT());
    }
}
