package com.hzy.demo.Thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//lock
public class ThreadDemo1 {

    private static final Logger logger = LoggerFactory.getLogger(ThreadDemo1.class);

    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        // TODO Auto-generated method stub

        new Thread(()->{
            lock.lock();
                logger.info("--------------------");
            try {
                TimeUnit.SECONDS.sleep(6);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            lock.unlock();
        },"tn").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        for(int i=0;i<10;i++){
            new Thread(()->{
                lock.lock();
                /*try {
                    TimeUnit.NANOSECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                logger.info("--------------------");
                lock.unlock();
            },"t"+i).start();
        }
    }
}
