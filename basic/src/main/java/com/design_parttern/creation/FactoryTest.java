package com.design_parttern.creation;

public class FactoryTest {
    public static void main(String[] args) {
        Factory factory = new ConcreteFactory();
        Product product = factory.createProduct("A");
        System.out.println(product.getProductName());
    }
}

abstract class Product {
    String name;

    public String getProductName() {
        return name;
    }
}

class ConcreteProductA extends Product {
    public ConcreteProductA() {
        name = "A";
    }
}

class ConcreteProductB extends Product {
    public ConcreteProductB() {
        name = "B";
    }

}

class ConcreteProductC extends Product {
    public ConcreteProductC() {
        name = "";
    }

}

abstract class Factory {
    Product product;

    protected abstract Product createProduct(String type);

    public Product getProduct(String type) {
        product = createProduct(type);
        return product;
    }

}

class ConcreteFactory extends Factory {

    @Override
    protected Product createProduct(String type) {
        if ("A".equals(type)) {
            return new ConcreteProductA();
        }
        if ("B".equals(type)) {
            return new ConcreteProductB();
        }
        return new ConcreteProductC();
    }
}