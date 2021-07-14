package com.hzy.demo.Thread;

import java.util.concurrent.*;

public class ThreadDemo5 {

    /*线程池*/
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(6);

        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int i = 10;
                /*for(int j=0;j<100;j++){
                    i++;
                }*/
                i = i/0;
                /*TimeUnit.SECONDS.sleep(20);*/
                return i;
            }
        };
        Future<Integer> future0 = executorService.submit(callable);

       /* Future<Integer> future1 = executorService.submit(callable);

        Future<Integer> future2 = executorService.submit(callable);

        Future<Integer> future3 = executorService.submit(callable);

        Future<Integer> future4 = executorService.submit(callable);

        System.out.println(future0.isDone());*/

        try {
            int a = future0.get();
            /*System.out.println(a);*/
        }catch (Exception e){
            System.out.println("发生异常");
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }

       /* int b = future1.get();
        System.out.println(b);

        int c = future2.get();
        System.out.println(c);

        int d =  future3.get();
        System.out.println(d);

        int e = future4.get();
        System.out.println(e);*/
    }
}
