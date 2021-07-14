package com.hzy.demo.Thread;

import java.sql.Time;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/*main主线程如何获取分支线程的结果*/
public class ThreadDemo4 {

    static int i = 0;

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        /*Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int j=0;j<100;j++){
                    i++;
                }
            }
        });
        thread.start();*/
        /*答案1：通过if语句判断i的值是否等于100 如果不等于 Thread执行睡眠 */

        /*
        if (i!=100){
            Thread.sleep(5000);
        }
        System.out.println("i="+i);*/

        /*答案2 ： 通过join方法 join让主线程阻塞*/
        /*thread.join();
        System.out.println("i="+i);*/

        /* 通过实现 Callable接口  */
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                for(int j=0;j<100;j++){
                    i++;
                }
               /* TimeUnit.SECONDS.sleep(20);*/
                return i;
            }
        };

        FutureTask futureTask = new FutureTask(callable);

        Thread thread = new Thread(futureTask);



        thread.start();

        /*if (!futureTask.isDone()){
            System.out.println("task has not finished!");
        }*/

        System.out.println("123");
        int j = (int) futureTask.get();
        System.out.println("456");
        System.out.println(j);
        System.out.println("789");
    }
}
