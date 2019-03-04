package com.exercise.Concurrent.lock;

import java.util.concurrent.atomic.AtomicReference;


public class ReentrantLockTest{
    public static void main(String[] args) throws Exception {
        new ReentrantLock().lockA();
    }
}

class ReentrantLock{
    synchronized void lockA() throws Exception{
        Thread.sleep(1000);
        this.lockB();
    }
    synchronized void lockB() throws Exception{
        Thread.sleep(1000);
    }
}
/**
 * 不可重入锁
 */
class UnreentrantLock implements LockOps {
    private AtomicReference<Thread> atomicReference = new AtomicReference<>();

    @Override
    public void lock() {
        Thread current = new Thread();
        // 自旋锁模拟
        for (; ; ) {
            // 如果不为空则自旋等待
            if (!atomicReference.compareAndSet(null, current)) {
                return;
            }
        }
    }

    @Override
    public void unLock() {
        Thread current = new Thread();
        atomicReference.compareAndSet(current, null);
    }
}