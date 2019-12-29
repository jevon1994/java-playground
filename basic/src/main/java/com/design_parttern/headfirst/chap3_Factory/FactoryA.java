package com.design_parttern.headfirst.chap3_Factory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FactoryA implements  AbstractFactory{
    @Override
    public ExtendA createProductA() {
      log.info("Product A of FactoryA");
        return null;
    }

    @Override
    public void createProductB() {
        log.info("Product B of FactoryA");
    }
}
