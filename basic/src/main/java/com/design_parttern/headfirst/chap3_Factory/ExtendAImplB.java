package com.design_parttern.headfirst.chap3_Factory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExtendAImplB implements ExtendA {
    @Override
    public void create() {
        log.info("This is a B for ExtendA");
    }
}
