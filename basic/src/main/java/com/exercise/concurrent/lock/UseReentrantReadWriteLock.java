package com.exercise.concurrent.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName UseReentrantReadWriteLock
 * @Description
 * @Author Jevon
 * @Date2019/12/27 15:28
 **/
public class UseReentrantReadWriteLock {
    private ReentrantReadWriteLock rwLock =
            new ReentrantReadWriteLock();
    private ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock();
    private ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock();

    public void read() {
        try {
            readLock.lock();
            System.out.println("当前线程:" + Thread.currentThread().getName() + "进入...");
            Thread.sleep(3000);
            System.out.println("当前线程:" + Thread.currentThread().getName() + "退出...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }

    public void write() {
        try {
            writeLock.lock();
            System.out.println("当前线程:" + Thread.currentThread().getName() + "进入...");
            Thread.sleep(3000);
            System.out.println("当前线程:" + Thread.currentThread().getName() + "退出...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        final UseReentrantReadWriteLock urrw =
                new UseReentrantReadWriteLock();

        Thread t1 =
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        urrw.read();
                    }
                }, "t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                urrw.read();
            }
        }, "t2");

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                urrw.write();
            }
        }, "t3");

        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                urrw.write();
            }
        }, "t4");

        t1.start();
//        t3.start();
//        t4.start();
        t2.start();
    }
}
