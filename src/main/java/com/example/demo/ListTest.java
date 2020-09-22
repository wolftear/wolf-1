package com.example.demo;

import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author yiche
 * @Description TODO
 * Date Created in 2020/6/4
 **/
public class ListTest {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);
        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);
        list1.removeAll(list2);
        System.out.println(list1.toString());

        System.out.println(CollectionUtils.isEmpty(new ArrayList<>()));
    }
}
