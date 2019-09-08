package com.designPattern.headfirst.chap1_observer.native_observer;

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("“I’m flying!!");
    }
}
