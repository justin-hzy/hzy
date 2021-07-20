package com.hzy.demo.Thread.线程中断.一般标志位法退出线程;

import java.util.concurrent.atomic.AtomicBoolean;

public class Demo1 {

    private static final AtomicBoolean running = new AtomicBoolean(true);

    public static void main(String[] args) throws InterruptedException {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                while (running.get()){
                    long timestamp = System.currentTimeMillis();

                    timestamp = System.currentTimeMillis() - timestamp;

                    System.out.println("Thread run, total sleep = " + timestamp + "(ms)");
                }
                System.out.println("Thread exit");
            }
        };

        Thread thread = new Thread(r1, "r1");

        System.out.println("start thread");

        thread.start();

        Thread.sleep(100);

        System.out.println("interrupt thread");

        /*thread.interrupt();*/

        running.set(false);

        System.out.println("main exit");

    }
}
