package com.hzy.demo.Thread.线程中断.中断即唤醒阻塞和休眠的线程;

public class Demo1 {

    public static void main(String[] args) throws InterruptedException {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println("Thread will sleep 10s ------------------------- running");
                    long timestamp = System.currentTimeMillis();
                    try {
                        Thread.sleep(10000);

                    } catch (InterruptedException e) {
                        System.out.println("thread interrupted...");

                    }
                    timestamp = System.currentTimeMillis() - timestamp;
                    System.out.println("Thread run, total sleep = " + timestamp + "(ms)");
                }
            }
        };

        Thread thread = new Thread(r1,"r1");

        System.out.println("start thread");

        thread.start();

        Thread.sleep(3000);

        System.out.println("interrupt thread");

        thread.interrupt();

        System.out.println("main exit");

    }
}
