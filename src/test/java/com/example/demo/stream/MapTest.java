package com.example.demo.stream;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Author yiche
 * @Description TODO
 * Date Created in 2019/12/12
 **/
public class MapTest {

    public static void main(String[] args) {
        HashMap<String,String> hm = new HashMap<>();
        hm.put("111","222");
        Set<Map.Entry<String,String>> entrySet = hm.entrySet();
        Iterator<Map.Entry<String,String>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String,String> entry = iterator.next();
            System.out.println(entry.getKey() + " " +entry.getValue());
        }

        for (String str:hm.keySet()) {
            System.out.println(str);
        }
    }
}
