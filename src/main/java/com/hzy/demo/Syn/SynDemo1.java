package com.hzy.demo.Syn;

import com.hzy.demo.Demo;
import org.openjdk.jol.info.ClassLayout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SynDemo1 {

    static SynDemo1 synDemo1;

    public static void main(String[] args) throws InterruptedException{
        synDemo1 = new SynDemo1();
        /*synDemo1.hashCode();*/
        /*synchronized (synDemo1){
            System.out.printf(ClassLayout.parseInstance(synDemo1).toPrintable(synDemo1));

        }*/
        /*Logger logger = LoggerFactory.getLogger(SynDemo1.class);
        logger.debug(ClassLayout.parseInstance(synDemo1).toPrintable());*/
        System.out.printf(ClassLayout.parseInstance(synDemo1).toPrintable(synDemo1));

    }
}

