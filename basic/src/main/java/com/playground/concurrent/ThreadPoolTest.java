package com.playground.concurrent;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 20; i++) {
            ThreadPoolExecutor threadPoolExecutor = threadPoolDown();
            threadPoolExecutor.execute(() -> {
                System.out.println("exec======");
            });

        }

        Thread.sleep(9999999);
    }

    public void threadPool() {

        /**
         * 1.固定大小的线程池
         *  阻塞队列是一个无界队列LinkedBlockingQueue，线程数量将永远维持在nThreads
         *  <P></P>
         */

        Executors.newFixedThreadPool(5);

        /**
         * 2. 无限扩大的线程池
         * 阻塞队列没有存储空间，有请求到来，就必须要找到一条工作线程处理
         * <P>适合处理执行时间比较小的任务</P>
         */
        Executors.newCachedThreadPool();

        /**
         * 3. 单例
         * 阻塞队列是一个无界队列LinkedBlockingQueue
         */
        Executors.newSingleThreadExecutor();

        /**
         * 4. 延时任务或定时任务
         * 阻塞队列 : DelayQueue(无界队列)
         */
        Executors.newScheduledThreadPool(5);
    }

    public static ThreadPoolExecutor threadPoolDown() {
        return new ThreadPoolExecutor(10, 20, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1024)
                , new ThreadFactoryBuilder().setNameFormat("test").build(), new ThreadPoolExecutor.AbortPolicy());
    }
}