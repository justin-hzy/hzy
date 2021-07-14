package com.hzy.demo.Thread;

public class ThreadDemo6 {

    private static  int number = 1;

    public static void main(String[] args) {

        final Object monitor = new Object();

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                while (true){
                    /*boolean interrupted = Thread.currentThread().isInterrupted();
                    if (interrupted){
                        break;
                    }*/
                    synchronized (monitor){
                        if (number%2 ==0){
                            try {
                                monitor.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("奇数线程, number:"+number);
                        number++;

                        monitor.notify();
                    }

                    /*try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/

                }

            }
        };

        Thread thread1 = new Thread(runnable1);

        thread1.start();

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                while (true){
                    /*boolean interrupted = Thread.currentThread().isInterrupted();
                    if (interrupted){
                        break;
                    }*/
                    synchronized (monitor){
                        if (number%2 != 0){
                            try {
                                monitor.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("偶数线程, number:"+number);

                        number++;
                        monitor.notify();
                    }

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread thread2 = new Thread(runnable2);

        thread2.start();
    }
}
