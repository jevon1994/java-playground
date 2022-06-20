package com.playground.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipeExample {
    public static void main(String[] args) throws IOException {
        final PipedOutputStream output = new PipedOutputStream();
        final PipedInputStream input = new PipedInputStream(output);
        // 从程序向管道中写入
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    output.write("=========== Test ===========".getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        output.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        // 程序从管道中读取
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int data = input.read();
                    while (data != -1) {
                        System.out.println(data);
                        data = input.read();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        input.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        });


        t1.start();
        t2.start();
    }
}
