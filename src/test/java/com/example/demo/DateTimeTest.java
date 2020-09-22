package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author yiche
 * @Description TODO
 * Date Created in 2020/7/20
 **/
public class DateTimeTest {
    /**
     * 时间戳按指定格式转化为日期（String）
     * @param timestamp
     * @param pattern
     * @return
     */
    public static String convertTimestamp2Date(Long timestamp, String pattern) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        return simpleDateFormat.format(new Date(timestamp));
    }

    public static void main(String[] args) {

        Long timestamp = System.currentTimeMillis();
        System.out.println(timestamp);
        String pattern = "yyyy-MM-dd HH:mm:ss";

        System.out.println(convertTimestamp2Date(1595196424L, pattern));

        //String str = "在家闲着没事干，提着菜篮子去果园转转，还有几个纽荷尔脐橙没釆???";
        //System.out.printf(str.length()+"");
        List<String> stringList = new CopyOnWriteArrayList<>() ;
        stringList.add("aaa");
        stringList.add("bbb");
        stringList.add("ccc");
        stringList.add("ddd");
        System.out.println(stringList.get(3));
        System.out.println(stringList.size());
        stringList.remove(stringList.size()-2);
        System.out.println(stringList.size());
        System.out.println(stringList);
        System.out.println(stringList.subList(0,1));
        System.out.println(stringList);
        System.out.println("messages为空-UGC--".split("-UGC-")[0]);
        System.out.println("messages为空-UGC--".split("-UGC-")[1]);
    }

}
