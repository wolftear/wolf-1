package com.example.demo.多线程;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author yiche
 * @Description TODO
 * Date Created in 2020/4/15
 **/
public class ThreadPoolExecutorTest {
    public static void main(String[] args) throws InterruptedException{
        // 创建线程池
        BlockingQueue<Runnable> queue = new LinkedBlockingDeque<>(50000);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 30, 60L, TimeUnit.SECONDS, queue);

        for (int i = 0; i < 10000; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName());
                        Thread.currentThread().sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        Thread.sleep(500);
        int coreSize = executor.getCorePoolSize();
        int maxSize = executor.getMaximumPoolSize();
        int usedPoolSize = executor.getPoolSize();
        long completedTask = executor.getCompletedTaskCount();
        int queuesize = executor.getQueue().size();
        System.out.println();
    }
}
