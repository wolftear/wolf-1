package com.example.demo.阿里规约;

/**
 * @Author yiche
 * @Description TODO
 * Date Created in 2020/4/13
 **/
public class IfSingelStatemetTest {
    public static void main(String[] args) {
        // 严格学习阿里规约
        String say = "hello";
        int flag = 0;
        if (flag == 0) {
            System.out.println(say);
        }
        if (flag == 1) {
            System.out.println("world");
        } else {
            System.out.println("ok");
        }
        System.out.println(Integer.MAX_VALUE);
        String str = "a,b,c,,";
        String[] ary = str.split(",");
        // 预期大于 3，结果是 3
        System.out.println(ary.length);
    }
}
