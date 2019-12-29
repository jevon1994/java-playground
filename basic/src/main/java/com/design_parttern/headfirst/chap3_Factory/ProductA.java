package com.design_parttern.headfirst.chap3_Factory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductA extends AbstractProduct {
    @Override
    void create() {
        log.info("1111111111111111");
    }
}
