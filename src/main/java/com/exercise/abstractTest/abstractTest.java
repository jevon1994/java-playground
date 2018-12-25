package com.exercise.abstractTest;

public class abstractTest {
    public static void main(String[] args) {
        new D().bye();
    }
}

interface A {
    public void hello();

    public void hi();
}

interface B {

    public void say();

    public void talk();
}

abstract class C implements A, B {
    @Override
    public void hello() {
        System.out.println("hello");
    }

    @Override
    public void say() {
        System.out.println("say");
    }

    abstract void bye();
}

class D extends C {
    /**
     * 实现接口类
     */
    @Override
    public void hello() {
        super.hello();
    }

    @Override
    public void say() {
        super.say();
    }

    /**
     * 必须实现抽象类未实现的方法
     */
    @Override
    public void hi() {

    }


    @Override
    public void talk() {

    }

    @Override
    void bye() {
        System.out.println("bye");
    }
}