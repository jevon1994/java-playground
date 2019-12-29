package com.design_parttern.headfirst.chap3_Factory;

public class ConcreteStoreA extends AbstractStoreA {
    @Override
    protected AbstractProduct createProduct(String name) {
        AbstractProduct abstractProduct = null;
        AbstractFactory abstractFactory = new  FactoryA();
        if(name.equals("hello")){
            return new ProductA();
        }
        return null;
    }
}
