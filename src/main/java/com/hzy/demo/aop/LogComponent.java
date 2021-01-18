package com.hzy.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogComponent {

    @Pointcut("execution(* com.hzy.demo.service.*.*(..))")
    public void LogComponent(){

    }

    @Before(value = "LogComponent()")
    public void before(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        System.out.println("before>>>>>>>>"+name);
    }

    @After(value = "LogComponent()")
    public void after(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        System.out.println("after>>>>>>>>"+name);
    }

    /*@Around(value = "LogComponent()")
    public void around(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        System.out.println("around>>>>>>>>"+name);
    }*/
}
