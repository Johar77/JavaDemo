package com.johar.javawebdemo.protype;

import lombok.Data;

/**
 * @ClassName: Student
 * @Description: TODO
 * @Author: Johar
 * @Date: 2020/1/1 18:16
 * @Version: 1.0
 */
@Data
public class Student implements Cloneable {
    private String name;

    private Teacher teacher;

    @Override
    protected Student clone() throws CloneNotSupportedException {
        Student result = (Student)super.clone();
        return result;
    }

    public static void main(String[] args) throws Exception{
        Teacher teacher1 = new Teacher();
        teacher1.setName("汪老师");

        Student student1 = new Student();
        student1.setName("Johar");
        student1.setTeacher(teacher1);

        Student student2 = student1.clone();
        student2.setName("Anna");
        student2.getTeacher().setName("李老师");

        System.out.println("student1: " + student1.getName());
        System.out.println("student1: " + student1.getTeacher().getName());
        System.out.println("student2: " + student2.getName());
        System.out.println("student1: " + student1.getTeacher().getName());
        System.out.println(student1 == student2);
    }
}
