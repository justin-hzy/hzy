package com.hzy.demo.Thread.线程中断;

import org.apache.poi.ss.formula.functions.T;

public class Demo1 {

    public static void main(String[] args) throws InterruptedException {
        try {
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(20);//modify 2000 to 20
            thread.interrupt();//请求中断MyThread线程
        }
        catch(InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end!");



    }
}
