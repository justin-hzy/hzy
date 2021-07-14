package com.hzy.demo.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class InputFileStreamDemo {

    public static void main(String[] args) {
        try {
            InputStream is = null;
            File file = new File("D:\\io测试.txt");
            is = new FileInputStream(file);
            System.out.println();
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
