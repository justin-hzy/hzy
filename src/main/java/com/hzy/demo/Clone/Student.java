package com.hzy.demo.Clone;

public class Student implements Cloneable{

    String username;
    String age;

    Teacher teacher;

    public Student() {

    }

    public Student(String username, String age) {
        this.username = username;
        this.age = age;
        this.teacher = new Teacher();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacherName) {
        teacher.setTeachName(teacherName);
    }

    public void display(String p1){
        System.out.println(p1+":username=" + username + ", age=" + age +","+ teacher);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student student = (Student) super.clone();
        student.teacher = (Teacher) teacher.clone();
        return student;
    }
}
