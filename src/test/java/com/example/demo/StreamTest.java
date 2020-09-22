package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author yiche
 * @Description TODO
 * Date Created in 2020/7/2
 **/
public class StreamTest {
    public static void main(String[] args) {
        List<Integer> sixNums = Arrays.asList(1, 2, 3, 4, 5, 6);
        sixNums = sixNums.stream().filter(n -> (n % 2 != 0 && n != 1))
                .collect(Collectors.toList());
        Stream.of(sixNums).forEach(num -> System.out.print(num + " "));
    }
}
