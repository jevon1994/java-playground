package com.designPattern.headfirst.chap3_Factory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FactoryB implements  AbstractFactory{
    @Override
    public void createProductA() {
      log.info("Product A of FactoryB");
    }

    @Override
    public void createProductB() {
        log.info("Product B of FactoryB");
    }
}
