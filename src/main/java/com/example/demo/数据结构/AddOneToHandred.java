package com.example.demo.数据结构;

/**
 * @Author yiche
 * @Description TODO
 * Date Created in 2020/2/22
 **/
public class AddOneToHandred {
    public static void main(String[] args) {
        int total = 0;
        int end = 100;
        for (int i = 1; i<=end;i++) {
            total +=i;
        }
        System.out.println((1+end)*(100>>1));
        System.out.println(total);
    }

}
