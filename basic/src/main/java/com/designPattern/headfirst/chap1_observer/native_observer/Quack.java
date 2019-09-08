package com.designPattern.headfirst.chap1_observer.native_observer;

public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.printf("Quack");
    }
}
