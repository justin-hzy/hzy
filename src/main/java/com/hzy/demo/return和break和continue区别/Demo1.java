package com.hzy.demo.return和break和continue区别;

public class Demo1 {

    public static void main(String[] args) {
        testBreak();
        testContinue();
        testReturn();
        System.out.println("--主函数------------");
    }

    /**
     * break测试方法
     */
    private static void testBreak() {
        for(int j = 0;j<3;j++){
            for (int i = 0; i < 5; i++) {

                if (i == 3) {
                    break;
                }
                System.out.println("--break------------" + i);
            }
            System.out.println("--break-------for循环外-----");
        }


    }


    /**
     * continue测试方法
     */
    private static void testContinue() {
        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                continue;
            }
            System.out.println("--continue------------" + i);
        }
        System.out.println("--continue-------for循环外-----");
    }


    /**
     * Return测试方法
     */
    private static void testReturn() {
        for(int j = 0;j<3;j++){
            for (int i = 0; i < 5; i++) {

                if (i == 3) {
                    break;
                }
                System.out.println("--return------------" + i);
            }
            System.out.println("--return-------for循环外-----");
        }

    }

}
