package com.designPattern.headfirst.chap1;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.printf("silence");
    }
}
