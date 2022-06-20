package com.playground.InnerClass;

public class StaticClass {

}

/**
 * 静态内部类
 */
class OuterClass {
    private static int i = 5;

    public static class InnerClass {
        public void test() {
            System.out.println(i);
        }
    }


    public static void main(String[] args) {
        OuterClass.InnerClass inner = new OuterClass.InnerClass();
        inner.test();
    }
}