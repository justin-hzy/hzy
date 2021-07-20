package com.hzy.demo.泛型;

import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.List;

public class POJO1<T> {

    private T t;

    public POJO1() {
    }

    public POJO1(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "POJO1{" +
                "t=" + t +
                '}';
    }
}
