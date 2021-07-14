package com.hzy.demo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Demo {
    private static int i=1;

    static Runnable runnable;
    public static void main(String args[]) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
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
/*        float i = 2/4;
        System.out.println(i);
        ArrayList list = new ArrayList();

        HashMap m = new HashMap(9);
        Method capacityMethod = m.getClass().getDeclaredMethod("capacity");
        capacityMethod.setAccessible(true);
        int capacity = (int) capacityMethod.invoke(m);
        System.out.println("aa="+(1 << 30));*/




       /* System.out.println("Math.random()="+Math.random());*/

/*        System.out.println("请20个数字");

        List<Integer> list = new ArrayList<Integer>(20);
        for(int i = 0;i<20;i++){
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            Integer num = Integer.valueOf(str);
            list.add(num);
        }
        System.out.println(list.toString());

        System.out.println("进行排序");

        Collections.sort(list);
        System.out.println(list.toString());*/


        runnable = new Runnable(){

            @Override
            public void run() {

            }
        };

    }
    static void my360D(){
        System.out.print("360");
    }

    public void getNext(){
         i++;
    }
}
