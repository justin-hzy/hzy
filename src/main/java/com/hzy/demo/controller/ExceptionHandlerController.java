package com.hzy.demo.controller;

import com.hzy.demo.commons.JSONResult;
import com.hzy.demo.exception.MyException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("ExceptionHandlerController")
public class ExceptionHandlerController {

    @RequestMapping(value = "/test",produces = "application/json;charset=utf-8" ,method = RequestMethod.GET)
    public JSONResult test() throws Exception {
        int i = 1/0;
        return JSONResult.ok();
    }

    @RequestMapping(value = "/test1",produces = "application/json;charset=utf-8" ,method = RequestMethod.GET)
    public JSONResult test1() throws Exception {
        try{
            int i = 1/0;
        }catch (RuntimeException e){
           throw new MyException("自定义异常");
        }
        return JSONResult.ok();
    }
}
