package com.hzy.demo.annotate;

import org.aspectj.lang.annotation.Aspect;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Token {
}
