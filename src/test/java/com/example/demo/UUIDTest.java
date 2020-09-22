package com.example.demo;

import java.util.UUID;

/**
 * @Author yiche
 * @Description TODO
 * Date Created in 2020/6/22
 **/
public class UUIDTest {
    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString().replaceAll("-",""));
        System.out.println(UUID.randomUUID().toString().replaceAll("-",""));
    }
}
