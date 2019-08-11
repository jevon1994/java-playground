package com.designPattern.headfirst.chap1;

public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.printf("Squeak");
    }
}
