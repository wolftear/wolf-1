package com.example.demo.正则;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author yiche
 * @Description TODO
 * Date Created in 2020/5/25
 **/
public class StringTest {
    public static void main(String[] args) {
        String str = "【最满意】1.油耗低，【最不满意】不好开";
        String pattern = "([(.*?)])";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        System.out.println(m.matches());

        String[] split = str.split(pattern);
        for (String strs : split) {
            System.out.println(strs);
        }
    }
}
