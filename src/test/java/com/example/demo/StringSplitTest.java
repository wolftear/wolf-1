package com.example.demo;

import com.example.demo.stream.Student;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author yiche
 * @Description TODO
 * Date Created in 2019-08-15
 **/
public class StringSplitTest {
    public static void main(String[] args) {
        String str = "a,b,c,,";
        String[] ary = str.split(",");
        System.out.println(ary.length);

        List<Student> studentList = new ArrayList<>();
        Student student = new Student();
        student.setId(1);
        student.setAge(100);
        student.setGrade("A");
        student.setName("张三");
        studentList.add(student);
        System.out.println(studentList.toString());

        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);
        System.out.println(Long.MAX_VALUE);

        System.out.println(new Integer(1).toString());
    }
}
