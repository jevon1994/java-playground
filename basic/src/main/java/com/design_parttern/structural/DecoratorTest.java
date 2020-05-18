package com.design_parttern.structural;

import lombok.AllArgsConstructor;

public class DecoratorTest {
    public static void main(String[] args) {
        Component component = new ConcreteComponet();
        Decorator decorator = new ConcreteDecorator(component);
        decorator.opertion();
    }
}

interface Component {
    void opertion();
}

class ConcreteComponet implements Component {

    @Override
    public void opertion() {
        System.out.println("doing sth");
    }
}

@AllArgsConstructor
class Decorator implements Component {
    private Component component;

    @Override
    public void opertion() {
        component.opertion();
    }
}

class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void opertion() {
        System.out.println("增加了新功能");
        super.opertion();
    }
}
