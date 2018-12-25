package com.exercise.generic;

public class GenericTest {
    public static void main(String[] args) {
        Apple apple = new Apple();
        Person person = new Person();
        GenerateTest<Fruit> generateTest = new GenerateTest<>();
        generateTest.show_1(apple);
        generateTest.show_2(apple);
        generateTest.show_3(apple);
//        generateTest.show_1(person);  // 编译器会报错，因为泛型类型实参指定的是Fruit，而传入的实参类是Person
        generateTest.show_2(person);
        generateTest.show_3(person);
    }
}

class Fruit {
    @Override
    public String toString() {
        return "fruit";
    }
}

class Apple extends Fruit {
    @Override
    public String toString() {
        return "apple";
    }
}

class Person {
    @Override
    public String toString() {
        return "Person";
    }
}

class GenerateTest<T> {
    public void show_1(T t) {
        System.out.println(t.toString());
    }

    // 泛型E可以为任意类型。可以类型与T相同，也可以不同
    public <E> void show_3(E t) {
        System.out.println(t.toString());
    }

    // 注意这个T是一种全新的类型，可以与泛型类中声明的T不是同一种类型
    public <T> void show_2(T t) {
        System.out.println(t.toString());
    }
}
