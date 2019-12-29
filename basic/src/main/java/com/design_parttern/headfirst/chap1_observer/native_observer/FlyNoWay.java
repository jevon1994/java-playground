package com.design_parttern.headfirst.chap1_observer.native_observer;

public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("“I can’t fly”");
    }
}
