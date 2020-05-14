package com.exercise.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class createThread {
    public static void main(String[] args) {
        new Create_1().start();

        Create_2 create_2 = new Create_2();
        Thread thread2 = new Thread(create_2);
        thread2.run();

        Create_3 create_3 = new Create_3();
        FutureTask<String> futureTask = new FutureTask<>(create_3);
        Thread thread = new Thread(futureTask);
        thread.start();
    }
}

/**
 * 1.继承Thread类
 */
class Create_1 extends Thread {

    @Override
    public void run() {
        System.out.println("creaet ================ 1");
    }
}

/**
 * 2.实现Runnable接口
 */
class Create_2 implements Runnable {

    @Override
    public void run() {
        System.out.println("creaet ================ 2");
    }
}

/**
 * 3.实现Callable接口
 */
class Create_3 implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("creaet ================ 3");
        return null;
    }
}