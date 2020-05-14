package com.exercise.concurrent;


class TestDeadLock {

    static Book book1 = new Book();
    static Book book2 = new Book();

    public static void main(String[] args) {
        runThread(book1, book2);
        runThread(book2, book1);
    }

    public static void runThread(Book obj1, Book obj2) {
        new Thread(() -> {
            try {
                synchronized (obj2) {
                    Thread.sleep(10);
                    obj1.getBook();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}

class Book {
    public synchronized Book getBook() {
        return new Book();
    }
}