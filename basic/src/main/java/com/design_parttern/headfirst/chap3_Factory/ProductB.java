package com.design_parttern.headfirst.chap3_Factory;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class ProductB extends AbstractProduct {
    AbstractFactory abstractFactory;
    @Override
    void create() {
        extendA = abstractFactory.createProductA();
        log.info("2222222222222");
    }
}
