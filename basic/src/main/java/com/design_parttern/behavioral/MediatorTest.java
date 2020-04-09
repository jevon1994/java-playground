package com.design_parttern.behavioral;

/**
 * 中介对象封装一系列的交互
 */
public class MediatorTest {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        mediator.invoke();
    }
}


interface Mediator {
    void invoke();
}

class ConcreteMediator implements Mediator {

    @Override
    public void invoke() {
        new OperatorA().operate();
        new OperatorB().operate();
    }
}

class OperatorA {
    void operate() {
        System.out.println("Operator A");
    }


}

class OperatorB {
    void operate() {
        System.out.println("Operator B");
    }
}