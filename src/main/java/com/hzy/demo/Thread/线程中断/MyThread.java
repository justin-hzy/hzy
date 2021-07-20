package com.hzy.demo.Thread.线程中断;

public class MyThread extends Thread{
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 500000; i++) {
            if (this.interrupted()) {
                System.out.println("should be stopped and exit");
                return;
            }
            System.out.println("i=" + (i + 1));
        }
        //尽管线程被中断,但并没有结束运行。这行代码还是会被执行
        System.out.println("this line is also executed. thread does not stopped");
    }
}
