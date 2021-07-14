package com.hzy.demo.Clone;

public class CloneDemo {

    public static void main(String[] args) throws CloneNotSupportedException {

        Student student1 = new Student("张三","20");

        student1.setTeacher("郭老师");

        Student student2 = (Student) student1.clone();

        System.out.println("student1="+student1);

        System.out.println("student2="+student2);

        student1.display("学生1");

        student2.display("学生2");

        System.out.println("改变引用值之后");

        student2.setTeacher("陈老师");

        student1.display("学生1");

        student2.display("学生2");




       /* Person p1 = new Person("zhangsan",21);
        p1.setAddress("湖北省", "武汉市");
        Person p2 = (Person) p1.clone();
        System.out.println("p1:"+p1);
        System.out.println("p1.getPname:"+p1.getPname().hashCode());

        System.out.println("p2:"+p2);
        System.out.println("p2.getPname:"+p2.getPname().hashCode());

        p1.display("p1");
        p2.display("p2");
        p2.setAddress("湖北省", "荆州市");
        System.out.println("将复制之后的对象地址修改：");
        p1.display("p1");
        p2.display("p2");*/


    }
}
