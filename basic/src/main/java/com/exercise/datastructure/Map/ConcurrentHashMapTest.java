package com.exercise.datastructure.Map;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
    static Map<Long, String> conMap = new ConcurrentHashMap<Long, String>();

    public static void main(String[] args) throws InterruptedException {
        for (long i = 0; i < 100; i++) {
            conMap.put(i, i + "");
        }
        thread();

    }

    public static void test(){
        for (Iterator<Map.Entry<Long, String>> iterator = conMap.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry<Long, String> entry = iterator.next();

            System.out.println(Thread.currentThread().getName() + entry.getKey() + " - " + entry.getValue());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void thread(){
        Thread thread = new Thread(new Runnable() {
            public void run() {
                test();
            }

        });
        thread.start();

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                test();
            }
        });
        thread2.start();
    }
}
