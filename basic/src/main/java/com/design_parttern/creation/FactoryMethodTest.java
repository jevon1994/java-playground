package com.design_parttern.creation;

/**
 * 工厂方法模式
 */
public class FactoryMethodTest {
    public static void main(String[] args) {
        AbstractFactory factory = new ConcreteFactory();
        AbstractProduct product = factory.produce();
        product.use();
    }
}

abstract class AbstractProduct {
    abstract void use();
}

abstract class AbstractFactory {
    abstract AbstractProduct produce();
}

class ConcreteProduct extends AbstractProduct {
    @Override
    void use() {
        System.out.println("product in use");
    }
}

class ConcreteFactory extends AbstractFactory {
    @Override
    AbstractProduct produce() {
        return new ConcreteProduct();
    }
}
