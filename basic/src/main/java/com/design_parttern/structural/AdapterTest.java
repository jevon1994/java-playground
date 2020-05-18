package com.design_parttern.structural;

import lombok.AllArgsConstructor;

public class AdapterTest {
    public static void main(String[] args) {
        Target classAdapter = new ClassAdapter();
        classAdapter.invoke();
        Target objApapter = new ObjectAdapter(new Adaptee());
        objApapter.invoke();
    }
}

interface Target {
    void invoke();
}

class Adaptee {
    public void concreteInvoke() {
        System.out.println("real invoke");
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