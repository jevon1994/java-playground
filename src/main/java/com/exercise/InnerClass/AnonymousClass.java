package com.exercise.InnerClass;

public class AnonymousClass {
    public static void main(String[] args) {
        inner inner = new inner();
        inner.test();

        Test anony = new Test(){
            @Override
            public void test() {
                System.out.println("anony");
            }
        };
        anony.test();
    }
}


abstract class Test{
    public abstract void test();
}

class inner extends Test{

    @Override
    public void test() {
        System.out.println("test");
    }
}