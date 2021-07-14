package com.hzy.demo.Clone;

public class Teacher implements Cloneable{

    private String teachName;

    public void setTeachName(String teachName){
        this.teachName = teachName;
    }

    @Override
    public String toString() {
        return "Teacher[" +
                "teachName='" + teachName + '\'' +
                ']';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
