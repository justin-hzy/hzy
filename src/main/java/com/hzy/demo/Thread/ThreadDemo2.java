package com.hzy.demo.Thread;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;


public class ThreadDemo2 {

    private static final Logger logger = LoggerFactory.getLogger(ThreadDemo2.class);

    public static void main(String[] args) throws InterruptedException {


        // TODO Auto-generated method stub
         Object o = new Object();

        new Thread(()->{
            synchronized (o) {
                logger.info("--------------------");
            }
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        },"tn").start();


        TimeUnit.SECONDS.sleep(1);

        for(int i=0;i<10;i++){
            new Thread(()->{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o) {
                    logger.info("--------------------");
                }
            },"t"+i).start();
        }
    }
}
