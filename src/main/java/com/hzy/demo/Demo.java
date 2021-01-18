package com.hzy.demo;

import java.util.ArrayList;

public class Demo {
    private static int i=1;

    public static void main(String args[]){
        /* 题目1
        int count = 1;
        int num = 0;
        for (int i=0;i<=100;i++){
            count = count++;
        }
        System.out.printf("count = "+count);
        */
/*        int count = 1;
        int num = 0;
        for (int i=0;i<=100;i++){
            count++;
        }
        System.out.printf("count = "+count);*/


        /* 题目2
        Thread thread = new Thread(){
                @Override
                public void run() {
                    my360D();
                }
            };
            thread.start();
            System.out.print("DW");
        * */

        /*题目 3
        String foo1 = args[1];
        String foo2 = args[2];
        String foo3 = args[3];
        * */

        /*题目4
        String str =
                "";
        System.out.print(str.split(",").length);
        * */

        /*题目 5*/

/*        Demo test=new Demo();
        Demo testObject=new Demo();
        test.getNext();
        testObject.getNext();
        System.out.println(i);*/
/*

        for(;true;){

        }
*/
        float i = 2/4;
        System.out.println(i);
        ArrayList list = new ArrayList();


    }
    static void my360D(){
        System.out.print("360");
    }

    public void getNext(){
         i++;
    }
}
