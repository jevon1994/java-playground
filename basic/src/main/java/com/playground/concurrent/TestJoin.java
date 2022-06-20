package com.playground.concurrent;

class TestJoin implements Runnable {

    private String name;

    public TestJoin(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(name + " " + i);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        TestJoin test1 = new TestJoin("线程A");
        TestJoin test2 = new TestJoin("线程B");
        //1. 创建状态
        Thread t1 = new Thread(test1);
        Thread t2 = new Thread(test2);
        //2. 就绪状态
        t1.start();
        for (int i = 0; i < 10; i++) {
            if (i > 2) {
                try {
                    // t1线程合并到主线程中，主线程停止执行过程，转而执行t1线程，直到t1执行完毕后继续。
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("========================" + i);
        }
    }
}