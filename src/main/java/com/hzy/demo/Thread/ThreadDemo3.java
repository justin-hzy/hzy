package com.hzy.demo.Thread;

public class ThreadDemo3 extends Thread{

    public void run() {
        System.out.println("In run");
        yield();
        System.out.println("Leaving run");
    }

    public static void main(String[] args) {
        (new ThreadDemo3()).start();
    }
}
