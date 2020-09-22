package com.example.demo;

import java.io.*;
import java.util.Scanner;

/**
 * @Author yiche
 * @Description TODO
 * Date Created in 2020/9/11
 **/
public class ReadFileTest2 {
    public static void main(String[] args) {
        //获取要读取的文件
        //File readFile=new File("/Users/yiche/Desktop/1.txt");
        FileInputStream inputStream = null;
        Scanner sc = null;
        try {
            inputStream = new FileInputStream("/Users/yiche/Desktop/1.txt");
            sc = new Scanner(inputStream,"UTF-8");
            Long totalCount = 0l;
            while(sc.hasNextLine()){
                totalCount++;
                System.out.println(sc.nextLine());
            }
            System.out.println("总用户数:"+totalCount);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //一定要关闭流,倒序关闭
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (sc != null) {
                    sc.close();
                }
            } catch (Exception e2) {
            }
        }
    }
    }
