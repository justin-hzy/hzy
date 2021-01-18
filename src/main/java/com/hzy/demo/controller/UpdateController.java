package com.hzy.demo.controller;

import com.hzy.demo.commons.JSONResult;
import com.hzy.demo.service.HzyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("aopTest")
    public String aopTest(){
        hzyService.aopTest();
        return new String("通过aop测试");
    }

    @PreDestroy
    public void destroy(){
        executorService.shutdown();
    }

    public void info(int i){
        System.out.println("执行了方法之后i="+i);
    }

}
