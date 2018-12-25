package com.exercise.Concurrent;

class TestRunnable implements Runnable {

    private String msg;

    public TestRunnable(String msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("hey===========" + Thread.currentThread().getName());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread.yield();
        }
        System.out.println(this + msg + Thread.currentThread().getName());
    }


    public static void main(String[] args) {
        TestRunnable tt1 = new TestRunnable(":A");
        Thread t1 = new Thread(tt1);
        t1.start();
        Thread t2 = new Thread(tt1);
        t2.start();
        Thread t3 = new Thread(tt1);
        t3.start();
    }
}