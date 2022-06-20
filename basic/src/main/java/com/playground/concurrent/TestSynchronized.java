package com.playground.concurrent;

class TestSynchronized implements Runnable {

    private int count = 5;

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
//            synchronized (this) {
//
//            }
            if (count > 0) {

                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " = " + count--);
        }
    }
    public static void main(String[] args) {
        TestSynchronized test = new TestSynchronized();

        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        Thread t3 = new Thread(test);

        t1.start();
        t2.start();
        t3.start();
    }
}
