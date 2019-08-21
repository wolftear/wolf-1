package com.example.demo;

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
    }
}
