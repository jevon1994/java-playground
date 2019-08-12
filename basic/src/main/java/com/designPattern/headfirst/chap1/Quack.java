package com.designPattern.headfirst.chap1;

public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.printf("Quack");
    }
}
