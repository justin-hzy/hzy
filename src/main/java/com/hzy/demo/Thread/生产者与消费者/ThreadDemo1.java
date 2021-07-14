package com.hzy.demo.Thread.生产者与消费者;

import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;

public class ThreadDemo1 {

    public static void main(String[] args) {

        int max = 10;

        Queue queue = new ArrayBlockingQueue(max);


        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    synchronized (queue){
                        if(queue.size()<max){
                            String str = UUID.randomUUID().toString();
                            queue.add(str);

                            System.out.println(Thread.currentThread().getName()+"生产数据="+str);

                            try {
                                queue.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("123");
                        queue.notify();
                    }
                }
            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    synchronized (queue){
                        if (!queue.isEmpty()){
                          String str = (String) queue.poll();
                            System.out.println(Thread.currentThread().getName()+"获取信息="+str);
                            /*try {
                                queue.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }*/
                        }
                        /*System.out.println("456");*/
                        queue.notify();
                    }
                }
            }
        };

        Thread thread1 = new Thread(runnable1);

        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();
    }
}
