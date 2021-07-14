package com.hzy.demo.Thread.Java多线程龟兔赛跑;

public class RabbitAndTurtle extends Thread{

    public RabbitAndTurtle(String name) {
        super(name);
    }

    public int distance = 100;
    static boolean flag = true;
    public int preDistance = 0;

    @Override
    public void run() {
        double ran = Math.random();
        String name = currentThread().getName();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while(flag){
            if(ran<0.3){

            }
        }
    }
}
