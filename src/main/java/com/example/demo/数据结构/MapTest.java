package com.example.demo.数据结构;

import java.math.BigInteger;
import java.util.*;

/**
 * @Author yiche
 * @Description TODO
 * Date Created in 2020/3/3
 **/
public class MapTest {
    public static void main(String[] args) {
//        Map<Object,Object> map = new HashMap();
//        map.put("aa","111111");
//        map.put("bb","222222");
//        map.put("cc","333333");
//        for (Map.Entry<Object,Object> entry :map.entrySet()) {
//            System.out.println(entry.getKey() +"" +entry.getValue());
//        }
//
//        for (Object key :map.keySet()) {
//            System.out.println(key);
//        }
//        for (Object value: map.values()) {
//            System.out.println(value);
//        }
//
//        Iterator<Map.Entry<Object,Object>> entryIterator = map.entrySet().iterator();
//        while (entryIterator.hasNext()) {
//            Map.Entry<Object,Object> entry = entryIterator.next();
//            System.out.println(entry.getKey()+" " + entry.getValue());
//        }
//        System.out.println(1 << 30);
//        System.out.println(15 & 1);

//        String aa = "hashTesst";
//        System.out.println(aa.hashCode());
//        for (int i=1;i<16;i++) {
//            System.out.println("i:"+i+",hashCode:"+aa.hashCode());
//
//            System.out.println("结果" + (i & aa.hashCode()));
//        }

        BigInteger bigInteger = BigInteger.valueOf(9223372036854775807L);
        System.out.println(9223372036854775807L/3600L/24L/400);
        System.out.println(Long.MAX_VALUE);
        System.out.println(UUID.randomUUID().toString().replaceAll("-",""));
    }
}
