package com.example.demo;

import java.util.Random;

/**
 * @Author yiche
 * @Description TODO
 * Date Created in 2019-08-26
 **/
public class MathTest {
    public static void main(String[] args) {
        try {
            for (int i = 0; i < 10;i++) {
                Random random = new Random();
                int x = random.nextInt(10);
                String  str =  (x % 8) + "";
                System.out.println(i+"   "+str);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
