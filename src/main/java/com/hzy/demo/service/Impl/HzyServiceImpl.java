package com.hzy.demo.service.Impl;

import com.hzy.demo.Demo;
import com.hzy.demo.commons.SpringUtil;
import com.hzy.demo.mapper.HzyMapper;
import com.hzy.demo.service.HzyService;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class HzyServiceImpl implements HzyService {

    @Autowired
    private HzyMapper hzyMapper;

    Demo demo = new Demo();

    volatile int i;

    @Override
    public synchronized int threadSafe0() {
           /* synchronized实现多线程安全*/
           /*hzyMapper.updateNum((hzyMapper.getNum())-1);
           System.out.println("ThreadId="+Thread.currentThread().getId()+" i="+hzyMapper.getNum());*/


           /* volatile 配合 synchronized 实现多线程安全*/
           /*i = (hzyMapper.getNum())-1;
           hzyMapper.updateNum(i);
           System.out.println("ThreadId="+Thread.currentThread().getId()+" i="+hzyMapper.getNum());*/


             /* 因为i不是被volatile所以线程会读取线程本地内存的变量
            int i = (hzyMapper.getNum())-1;
            hzyMapper.updateNum(i);
            System.out.println("ThreadId="+Thread.currentThread().getId()+" i="+hzyMapper.getNum());*/

           /*int i = (hzyMapper.getNum())-1;
           hzyMapper.updateNum(i);
           System.out.println("ThreadId="+Thread.currentThread().getId()+" i="+hzyMapper.getNum());*/


        hzyMapper.updateNum((hzyMapper.getNum())-1);
        System.out.println("ThreadId="+Thread.currentThread().getId()+" i="+hzyMapper.getNum());



        return 0;
    }

    @Override
    public int threadSafe1() {
        synchronized (this){
            SpringUtil.getBean(this.getClass()).updateNum();
        }
        return 0;
    }

    @Override
    @Transactional
    public int threadSafe2() {
        hzyMapper.updateNum((hzyMapper.getNum1())-1);
        System.out.println("ThreadId="+Thread.currentThread().getId()+" i="+hzyMapper.getNum());
        return 0;
    }

    @Transactional
    @Override
    public int threadSafe3() {
        hzyMapper.updateNum((hzyMapper.getNum())-1);
        System.out.println("ThreadId="+Thread.currentThread().getId()+" i="+hzyMapper.getNum());
        return hzyMapper.getNum();
    }

    @Override
    public String aopTest() {
        System.out.println("aopTest");
        return new String("aopTest");
    }


    @Transactional
    public void updateNum(){
        i = (hzyMapper.getNum())-1;
        hzyMapper.updateNum(i);
        System.out.println("ThreadId="+Thread.currentThread().getId()+" i="+hzyMapper.getNum());
    }


}
