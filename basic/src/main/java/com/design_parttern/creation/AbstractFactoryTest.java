package com.design_parttern.creation;

public class AbstractFactoryTest {
    public static void main(String[] args) {
        FactoryA factoryA = new FactoryA();
        FactoryB factoryB = new FactoryB();
        factoryA.getMailSender().send();
        factoryA.getSmsSender().send();
        factoryB.getMailSender().send();
        factoryB.getSmsSender().send();
    }
}

// 1
abstract class AbstractMessageFactory {
    abstract Sender getSmsSender();

    abstract Sender getMailSender();
}

// 2
abstract class Sender {
    abstract void send();
}

// 3
abstract class SmsSender extends Sender {
    abstract void send();
}

abstract class MailSender extends Sender {
    abstract void send();
}

// 4
class ConcreteSmsSenderA extends SmsSender {

    @Override
    void send() {
        System.out.println("SmsSender send A");
    }
}

class ConcreteMailSenderA extends MailSender {
    @Override
    void send() {
        System.out.println("MailSender send A");
    }
}

class ConcreteSmsSenderB extends SmsSender {

    @Override
    void send() {
        System.out.println("SmsSender send B");
    }
}

class ConcreteMailSenderB extends MailSender {
    @Override
    void send() {
        System.out.println("MailSender send B");
    }
}

class FactoryA extends AbstractMessageFactory {

    @Override
    Sender getSmsSender() {
        return new ConcreteSmsSenderA();
    }

    @Override
    Sender getMailSender() {
        return new ConcreteMailSenderA();
    }
}

class FactoryB extends AbstractMessageFactory {

    @Override
    Sender getSmsSender() {
        return new ConcreteSmsSenderB();
    }

    @Override
    Sender getMailSender() {
        return new ConcreteMailSenderB();
    }
}
