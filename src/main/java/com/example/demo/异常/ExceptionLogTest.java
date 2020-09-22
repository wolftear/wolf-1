package com.example.demo.异常;

import org.jboss.logging.Logger;

import java.util.UUID;

/**
 * @Author yiche
 * @Description TODO
 * Date Created in 2020/5/7
 **/
public class ExceptionLogTest {
    public static void main(String[] args) {
        try {
            System.out.println(UUID.randomUUID());
        }catch (Exception e) {
        }

    }
}
