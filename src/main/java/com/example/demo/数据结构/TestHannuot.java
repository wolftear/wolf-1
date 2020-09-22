package com.example.demo.数据结构;

/**
 * @Author yiche
 * @Description TODO
 * Date Created in 2020/2/23
 **/
public class TestHannuot {
    public static void main(String[] args) {
        hannuot(3,"A","B","c");
    }

    /**
     * @Author yiche
     * @Description
     * @Date 下午5:12 2020/2/23
     * @Param [n 盘子个数, from 开始的柱子, in 中间的柱子, to 目标柱子]
     * @return void
     **/
    private static void hannuot(int n, String from, String in, String to) {
        if (n == 1) {
            System.out.println("第"+n+"个盘子从"+from+"移动到"+to);
        }else {
            hannuot(n-1,from,to,in);
            System.out.println("第"+n+"个盘子从"+from+"移动到"+to);
            hannuot(n-1,in,from,to);
        }

    }
}
