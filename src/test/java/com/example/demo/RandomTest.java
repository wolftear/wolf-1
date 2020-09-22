package com.example.demo;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author yiche
 * @Description TODO
 * Date Created in 2020/6/28
 **/
public class RandomTest {
    public static void main(String[] args) {
        Random r = null;
        try {
            r = SecureRandom.getInstanceStrong();
        } catch (Exception ex) {
        }
        int num = r.nextInt(10);
        System.out.println(num);
        System.out.println(ThreadLocalRandom.current().nextInt(10));
    }
}
