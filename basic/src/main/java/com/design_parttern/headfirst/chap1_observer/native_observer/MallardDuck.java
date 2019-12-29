package com.design_parttern.headfirst.chap1_observer.native_observer;

public class MallardDuck extends Duck {
    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.printf("green");
    }
}
