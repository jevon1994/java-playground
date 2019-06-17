package com.exercise.proxy.Cglib;

public class hello {
    public static void main(String[] args) {
        BookFacadeCglib cglib = new BookFacadeCglib();
        BookFacadeImpl1 bookCglib = (BookFacadeImpl1)cglib.getInstance(new BookFacadeImpl1());
        bookCglib.addBook();
    }
}
