package com.design_parttern.behavioral;

public class VisitorTest {
    public static void main(String[] args) {
        Visitor visitor = new ConcreteVisitor();
        Subject subject = new ConcreteSubject();
        System.out.println(subject.accept(visitor));

    }
}


interface Visitor{
    String visit();
}

class ConcreteVisitor implements Visitor{
    @Override
    public String visit() {
        return "visit";
    }
}

interface Subject{
    String accept(Visitor visitor);
}

class ConcreteSubject implements Subject{
    @Override
    public String accept(Visitor visitor) {
        return visitor.visit();
    }
}