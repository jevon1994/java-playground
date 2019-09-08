package com.designPattern.headfirst.chap1_observer.native_observer;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.printf("silence");
    }
}
