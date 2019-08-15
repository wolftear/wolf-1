package com.example.demo.stream;

import com.example.demo.stream.Student;

import java.util.Arrays;
import java.util.List;

/**
 * @Author yiche
 * @Description JDK1.8 Stream使用
 * Date Created in 2019-08-15
 **/
public class JdkStreamTest {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
        new Student(1,"zhangsan","class1",18,60),
        new Student(2,"lisi","class1",20,59),
        new Student(3,"wangwu","class2",18,100),
        new Student(4,"wangwu","class2",16,100),
        new Student(5,"wangwu","class2",22,100),
        new Student(6,"zhaoliu","class2",18,80));
        // allMatch(Predicate p) 检查是否匹配所以元素
        System.out.println("allMatch:"+students.stream().allMatch(e -> e.getGrade().contains("class1")));
        // anyMathc(Predicate p) 检查是否匹配一个元素
        System.out.println("anyMatch:"+students.stream().anyMatch(e -> e.getId() == 100));
        // noneMatch(Predicate p) 检查是否没有匹配所有元素
        System.out.println("noneMatch:"+students.stream().noneMatch(student -> student.getId() == 100));
        // findFirst() 返回第一个元素
        System.out.println("findFirst:"+students.stream().findFirst());
        // findAny() 返回当前流中的任意元素
        System.out.println("findAny:"+students.stream().findAny());
        // count() 返回流中元素总数
        System.out.println("count():"+students.stream().count());
        // filter
        System.out.println("filter():"+students.stream().filter(student -> student.getScore() == 100).count());
        // max(Comparator c) 返回流中最大值
        System.out.println("max:"+students.stream().map(e -> e.getAge()).max(Double::compare).get());
        // min(Comparator c) 返回流中最小值
        System.out.println("min:"+students.stream().map(e -> e.getAge()).min(Double::compare).get());
    }
}

