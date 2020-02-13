package com.example.demo.stream;

/**
 * @Author yiche
 * @Description TODO
 * Date Created in 2019-08-15
 **/
public class Student {
    private Integer id;
    private String name;
    private String grade;
    private Integer age;
    private Integer score;

    public Student(){};
    public Student(Integer id, String name, String grade, Integer age, Integer score) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.age = age;
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
