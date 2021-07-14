package com.hzy.demo.exception;

public class MyException extends RuntimeException{
    private Integer errorCode;
    private String errorMsg;

    public MyException(String errorMsg){
        super(errorMsg);
        this.errorMsg = errorMsg;
    }
    public MyException(Integer errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
