package exercise.Concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemophoreTest {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(4);
        for (int i = 0; i < 20; i++) {
            final int index = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        // 申请许可
                        semaphore.acquire();
                        System.out.println("Accessing: " + index);
                        Thread.sleep((long) (Math.random() * 6000));
                        // 释放
                        semaphore.release();
                        //availablePermits()指的是当前信号灯库中有多少个可以被使用
                        System.out.println("-----------------" + semaphore.availablePermits());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            // 执行
            exec.execute(runnable);
        }
        // 退出线程池
        exec.shutdown();
    }
}
