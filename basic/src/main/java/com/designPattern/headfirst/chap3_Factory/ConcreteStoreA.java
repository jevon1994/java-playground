package com.designPattern.headfirst.chap3_Factory;

public class ConcreteStoreA extends AbstractStoreA {
    @Override
    protected AbstractProduct createProduct(String name) {
        AbstractProduct abstractProduct = null;
        AbstractFactory abstractFactory = new  FactoryA();
        if(name.equals("hello")){
            return new
        }
        return null;
    }
}
