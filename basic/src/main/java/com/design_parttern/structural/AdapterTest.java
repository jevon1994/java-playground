package com.design_parttern.structural;

import lombok.AllArgsConstructor;

public class AdapterTest {
    public static void main(String[] args) {
        Target target = new ClassAdapter();
        target.invoke();
    }
}

interface Target {
    void invoke();
}

class Adaptee {
    public void concreteInvoke() {
        //todo sth
    }
}

// 类适配器
class ClassAdapter extends Adaptee implements Target {

    @Override
    public void invoke() {
        super.concreteInvoke();
    }
}

// 对象适配器
@AllArgsConstructor
class ObjectAdapter implements Target {
    private Adaptee adaptee;

    @Override
    public void invoke() {
        adaptee.concreteInvoke();
    }
}