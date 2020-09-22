package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author yiche
 * @Description TODO
 * Date Created in 2020/6/9
 **/
public class TimeStampTest {
    public static void main(String[] args) {
        Long timeStamp = 1591325368477L;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sd = sdf.format(new Date(Long.parseLong(String.valueOf(timeStamp))));      // 时间戳转换成时间
        System.out.println("格式化结果：" + sd);

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy 年 MM 月 dd 日 HH 时 mm 分 ss 秒");
        String sd2 = sdf2.format(new Date(Long.parseLong(String.valueOf(timeStamp))));
        System.out.println("格式化结果：" + sd2);
    }
}
