package com.example.demo.数据结构;

/**
 * @Author yiche
 * @Description TODO
 * Date Created in 2020/2/23
 **/
public class TestBinaryArray {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{1,2,3,4,5,6,7,8,9};

        //circleTest(array,Integer.valueOf(7));
        binaryTest(array,Integer.valueOf(-2));
    }

    private static void circleTest(Integer[] array, Integer target) {
        Integer count = 0;
        Integer index = -1;

        for (Integer i = 0;i<array.length;i++) {
            count ++;
            if (array[i].equals(target)) {
                index = i;
                break;
            }
        }
        System.out.println("线性循环执行次数，count:"+count);
        System.out.println("target元素的下标:index:"+index);

    }

    private static void binaryTest(Integer[] array,Integer target) {
        Integer begin = 0;
        Integer end = array.length -1;
        Integer mid = (begin+end)>>1;
        Integer index = -1;
        Integer count = 0;
        while (true) {
            count ++;
            System.out.println("begin:"+begin+",end:"+end);
            if (array[mid].equals(target)) {
                index = mid;
                break;
            }else {
                if (array[mid].intValue() > target.intValue()) {
                    end = mid - 1;
                    if (end <= begin) {
                        break;
                    }
                    mid = (begin+end)>>1;
                }else {
                    begin = mid + 1;
                    if (begin >= end) {
                        break;
                    }
                    mid = (begin+end)>>1;
                }
            }
        }
        System.out.println("二分查找执行次数，count:"+count);
        System.out.println("target元素的下标:index:"+index);
    }

}
