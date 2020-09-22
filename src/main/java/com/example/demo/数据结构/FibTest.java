package com.example.demo.数据结构;

/**
 * @Author yiche
 * @Description TODO
 * Date Created in 2020/2/13
 **/
public class FibTest {
    /**
     * @Author zhangzhiyong1
     * @Description  求第n个斐波那契数列 0 1 1 2 3 5 8 13 ...
     * @Date 下午4:10 2020/2/13
     * @Param [args]
     * @return void
     **/
    public static void main(String[] args) {
        Long start1Time = System.currentTimeMillis();
        System.out.println(fib1(40));
        System.out.println(System.currentTimeMillis() - start1Time);

        Long start2Time = System.currentTimeMillis();
        System.out.println(fib2(40));
        System.out.println(System.currentTimeMillis() -start2Time);

    }

    // fib1 O(2^n)
    private static Integer fib1(int n) {
        if (n <= 1) {
            return n;
        }else {
            return fib1(n-1) +fib1(n-2);
        }
    }

    // 0 1 1 2 3 5 O(log n)
    private static Integer fib2(int n) {
        if (n <= 1) {
            return n;
        }else {
            Integer first = 0;
            Integer second = 1;
            Integer sum = 0;
            for (int i=0;i<(n-1) ;i++) {
                sum = first + second;
                first = second;
                second = sum;
            }
            return second;
        }
    }

    // O(1)
    private static int fib3(int n) {
        double c = Math.sqrt(5);
        return (int) ((Math.pow((1+c)/2,n) - Math.pow((1-c)/2,n))/c);
    }



}
