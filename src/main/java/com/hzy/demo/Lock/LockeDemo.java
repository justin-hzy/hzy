package com.hzy.demo.Lock;

import java.util.concurrent.locks.ReentrantLock;

public class LockeDemo {
    public static void main(String[] args){
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.unlock();
    }
}
