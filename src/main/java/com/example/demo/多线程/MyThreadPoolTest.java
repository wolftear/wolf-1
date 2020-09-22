package com.example.demo.多线程;

import java.util.concurrent.*;

/**
 * @Author yiche
 * @Description
 *   手写一个线程池
 *
 *   类似于银行网点
 *   今天当值窗口为2
 *   最大窗口 5
 *   等待时间1秒钟
 *   候客区共三把椅子
 *   Date Created in 2020/4/15
 **/
public class MyThreadPoolTest {
    public static void main(String[] args) {

        ExecutorService threadPool = new ThreadPoolExecutor(2,
                5,
                10L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        // 使用 AbortPolicy 当线程数据超过 5 + 3 时，将会报RejectedExecutionException 异常
        try {
            for (int i = 1; i <= 100; i++) {
                final int temp = i;
                threadPool.execute(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getName() + "\t 办理业务! " + temp);
                    }
                });
//                Thread.sleep(200);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
