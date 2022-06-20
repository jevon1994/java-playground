package com.playground.concurrent;

public class ThreadCommunication {
    private static volatile boolean running = false;

    public void go() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // 开关
                while (!running) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 执行线程任务
                System.out.println("==================================");
            }
        });

        thread.start();
    }

    // 开始执行
    public void start() {
        running = true;
    }

    public static void main(String[] args) {
        ThreadCommunication t = new ThreadCommunication();
        t.start();
        t.go();

    }

}


