package com.design_parttern.creation;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 建造者
 */
public class BuilderTest {
    public static void main(String[] args) {
        BuilderClass builderClass = new ConcreteBuilder();
        Director director = new Director(builderClass);
        director.construct();
        builderClass.retrieveResult();
    }


}

@Data
class Prod {
    private String prod;
}

interface BuilderClass {
    Prod retrieveResult();
}

class ConcreteBuilder implements BuilderClass {
    private Prod prod = new Prod();

    @Override
    public Prod retrieveResult() {
        return prod;
    }
}

@AllArgsConstructor
class Director {
    private BuilderClass builderClass;

    public void construct() {
        builderClass.retrieveResult();
    }
}