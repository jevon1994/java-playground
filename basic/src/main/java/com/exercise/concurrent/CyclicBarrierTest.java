package com.exercise.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CyclicBarrierTest {
    public static void main(String[] args) throws InterruptedException {
        int n = 3;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> System.out.println("当前线程" + Thread.currentThread().getName()));
        Barrier barrier = new Barrier(cyclicBarrier);
        for (int i = 0; i < n; i++) {
            new Thread(barrier).start();
            // todo 验证 await(long timeout, TimeUnit unit)
//            if (i < n - 1) {
//                new Thread(barrier).start();
//            } else {
//                Thread.sleep(5000);
//            }
        }


        // todo 可重入性
        try {
            Thread.sleep(25000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("CyclicBarrier重用");

        for (int i = 0; i < n; i++) {
            new Thread(barrier).start();
        }
    }
}


class Barrier implements Runnable {
    private CyclicBarrier cyclicBarrier;

    public Barrier() {
    }

    public Barrier(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println("线程" + Thread.currentThread().getName() + "正在写入数据...");
        try {
            Thread.sleep(5000);
            System.out.println("线程" + Thread.currentThread().getName() + "写入数据完毕，等待其他线程写入完毕");
            /*
            线程等待至一定的时间，如果还有线程没有到达barrier状态就直接让到达barrier的线程执行后续任务
             */
            cyclicBarrier.await(2000, TimeUnit.MILLISECONDS);
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println("所有线程写入完毕，继续处理其他任务...");
    }
}