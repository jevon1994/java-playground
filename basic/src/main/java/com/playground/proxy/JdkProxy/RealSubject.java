package com.playground.proxy.JdkProxy;

public class RealSubject implements Subject {

    @Override
    public String say(String name, int age) {
        return name + " " + age;

    }
}