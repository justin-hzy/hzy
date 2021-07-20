package com.hzy.demo.Thread.线程中断.标志位线程中断结合;

import java.util.concurrent.atomic.AtomicBoolean;

public class Demo1 {

    private static final AtomicBoolean running = new AtomicBoolean(true);

    public static void main(String[] args) throws InterruptedException {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                while (running.get()) {
                    System.out.println("Thread will sleep 10s ------------------------- running");
                    long timestamp = System.currentTimeMillis();
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted... Todo other things then exit......");
                        running.set(false);
                        continue;
                    }
                    timestamp = System.currentTimeMillis() - timestamp;
                    System.out.println("Thread run, total sleep = " + timestamp + "(ms)");
                }
                System.out.println("Thread exit");
            }
        };

        Thread thread = new Thread(r1, "r1");

        System.out.println("start thread");

        thread.start();

        Thread.sleep(3000);

        System.out.println("interrupt thread");

        thread.interrupt();

        System.out.println("main exit");

    }
}
