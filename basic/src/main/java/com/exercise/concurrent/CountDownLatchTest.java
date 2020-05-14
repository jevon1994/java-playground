package com.exercise.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;

public class CountDownLatchTest {
    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(2);

        Task task = new Task(countDownLatch);
        FutureTask<String> futureTask = new FutureTask<String>(task);
        FutureTask<String> stringFutureTask = new FutureTask<String>(task);

        new Thread(futureTask).start();
        new Thread(stringFutureTask).start();

        try {
            System.out.println("等待2个子线程执行完毕...");
            countDownLatch.await();
            System.out.println("2个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Task implements Callable<String> {
    private CountDownLatch countDownLatch;

    public Task(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public String call() {
        System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
        countDownLatch.countDown();
        return null;
    }
}