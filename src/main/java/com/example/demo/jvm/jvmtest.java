package com.example.demo.jvm;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author yiche
 * @Description TODO
 * Date Created in 2020/3/16
 **/

public class jvmtest {
    public final static int OUTOFMEMORY = Integer.MAX_VALUE;

    private String oom;

    private int length;


    public jvmtest(int leng) {
        this.length = leng;
        List<Object> list = new ArrayList<>();

        while (true) {
            try {
                list.add(1);
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
                break;
            }
        }

    }

    public String getOom() {
        return oom;
    }

    public int getLength() {
        return length;
    }

    public static void main(String[] args) {
//        jvmtest javaHeapTest = new jvmtest(OUTOFMEMORY);
        System.out.println(LocalDateTime.now());
        LocalDateTime todayStartTime = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        System.out.println(todayStartTime);
        Map<String,String> map = new HashMap<>();
        map.put("aa","aaa");
    }

}
