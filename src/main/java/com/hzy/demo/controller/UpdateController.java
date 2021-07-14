package com.hzy.demo.controller;

import com.hzy.demo.commons.JSONResult;
import com.hzy.demo.mapper.HzyMapper;
import com.hzy.demo.service.HzyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PreDestroy;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@RestController
@RequestMapping("Hzy")
@Api(tags = "用户curd测试")
public class UpdateController {

    @Autowired
    private HzyService hzyService;

    @Autowired
    private HzyMapper hzyMapper;

    @Autowired
    private ExecutorService executorService;

    @ApiOperation("Swagger的测试")
    @GetMapping("update")
    public JSONResult update(){

        Callable callable = new Callable() {

            @Override
            public Object call() throws Exception {
                int i  = hzyService.threadSafe3();
                return i;
            }
        };

        synchronized (this){
            try {
                Future future = executorService.submit(callable);
                int i = (int) future.get();
                if (i>0){
                    info(i);
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        return JSONResult.build(200,"访问成功",new String("hello world!"));
    }

    /*@RequestMapping(value = "aopTest",produces = "application/json;charset=utf-8")*/
    @GetMapping("aopTest")
    public String aopTest(){
        hzyService.aopTest();
        return new String("通过aop测试");
    }

    //测试单个@Transactional如何处理runtime和非runtime的exception
    @GetMapping("updateNum1")
    @Transactional(rollbackFor = Exception.class)
    public void updateNum1() throws Exception {
        int flag = hzyMapper.updateNum(100);
        throw new Exception();
    }

    @RequestMapping(value = "/test", produces = "application/json;charset=utf-8")
    public String test(){
        return "nginx--测试";
    }

    //测试try catch对事务带来的影响
    @GetMapping("updateNum2")
    @Transactional
    public void updateNum2(){
        try{
            int flag = hzyMapper.updateNum(100);
            throw new RuntimeException();
        }catch (RuntimeException e){
            e.printStackTrace();
            throw e;
        }
    }

    //嵌套执行对事务带来的影响 start
    @GetMapping("updateNum3")
    @Transactional(rollbackFor = Exception.class)
    public void updateNum3() throws Exception {
        updateNum4();
        int flag = hzyMapper.updateNum(200);
    }

    @Transactional
    public void updateNum4() throws Exception {
       int flag = hzyMapper.updateNum(300);
       throw new Exception();
    }
    //嵌套执行对事务带来的影响 end

    //嵌套执行对事务带来的影响-使用上下文来处理 start
    @GetMapping("updateNum5")
    @Transactional
    public void updateNum5() throws Exception {
        UpdateController proxy =(UpdateController) AopContext.currentProxy();
        proxy.updateNum6();
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateNum6() throws Exception {
        int flag = hzyMapper.updateNum(300);
        throw new Exception();
    }
    //嵌套执行对事务带来的影响-使用上下文来处理 end

    @PreDestroy
    public void destroy(){
        executorService.shutdown();
    }

    public void info(int i){
        System.out.println("执行了方法之后i="+i);
    }

}
