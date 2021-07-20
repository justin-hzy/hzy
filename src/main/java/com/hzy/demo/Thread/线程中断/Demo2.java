package com.hzy.demo.Thread.线程中断;

import java.util.concurrent.atomic.AtomicBoolean;

public class Demo2 {

    private static final AtomicBoolean running = new AtomicBoolean(true);

    private  static int i;

    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (running.get()){
                    for (;i<100;i++){
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            running.set(false);
                            e.printStackTrace();
                            break;

                        }
                        System.out.println("i="+i);
                    }
                }
                System.out.println("Thread exit");
            }

        };

        Thread thread = new Thread(runnable, "r1");

        System.out.println("start thread");

        thread.start();

        Thread.sleep(100);

        System.out.println("interrupt thread");

        thread.interrupt();

        System.out.println("main exit");
    }
}
