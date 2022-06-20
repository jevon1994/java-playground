package com.playground.InnerClass;

public class LocalInnerClass {

    private int i = 1;

    public void method() {
        int b = 2;
        final int c = 3;
        class innerClass {
            public void test() {
                System.out.println(b);
                System.out.println(i);
            }
        }
        new innerClass().test();
    }


    public static void main(String[] args) {
        LocalInnerClass test = new LocalInnerClass();
        test.method();
    }
}
