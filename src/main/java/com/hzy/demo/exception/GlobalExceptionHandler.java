package com.hzy.demo.exception;

import com.hzy.demo.commons.JSONResult;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseDataSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "error";

    Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public JSONResult defaultErrorHandler() throws Exception {
        return JSONResult.errorMsg("统一异常拦截被触发");
    }

    /*自定义异常*/
    @ExceptionHandler(value = MyException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public JSONResult myExceptionHandler(HttpServletRequest request,MyException myException) throws Exception {
        myException.printStackTrace();
        logger.info("访问路径 : {} , 自定义异常信息 : {}",request.getRequestURI(),myException);
        return JSONResult.errorMsg(myException.getErrorMsg());
    }



}
