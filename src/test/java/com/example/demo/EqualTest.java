package com.example.demo;

/**
 * @Author yiche
 * @Description TODO
 * Date Created in 2019-08-15
 **/
public class EqualTest {
    public static void main(String[] args) {
        String testStr = "test";
        String paramStr = null;
        try {
//            if (testStr.equals(paramStr)) {
            if (paramStr.equals(testStr)) {
                System.out.println("参数正确");
            } else {
                System.out.println("参数错误");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
