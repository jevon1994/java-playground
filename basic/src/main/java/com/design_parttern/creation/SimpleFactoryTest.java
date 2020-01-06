package com.design_parttern.creation;

/**
 * 简单工厂模式
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {
        Factory factory = new Factory();
        Product product = factory.produce("A");
        product.use();
    }
}

interface Product {
    void use();
}

class ProductA implements Product {
    @Override
    public void use() {
        System.out.println("product A");
    }
}

class ProductB implements Product {

    @Override
    public void use() {
        System.out.println("product B");
    }
}

class Factory {
    public Product produce(String type) {
        if ("A".equals(type)) {
            return new ProductA();
        } else if ("B".equals(type)) {
            return new ProductB();
        } else {
            return null;
        }
    }
}
