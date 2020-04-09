package com.design_parttern.behavioral;

import lombok.Data;

public class ResponsibleChainTest {
    public static void main(String[] args) {
        ConcreteHandler handlerA = new ConcreteHandler("A");
        ConcreteHandler handlerB = new ConcreteHandler("B");
        ConcreteHandler handlerC = new ConcreteHandler("C");
        // 交由B先处理
        handlerA.setHandler(handlerB);
        // 交由C先处理
        handlerB.setHandler(handlerC);
        // 调用 C -> B -> A
        handlerA.handle();
        // 调用  C -> B
        handlerB.handle();

    }
}


interface Handler {
    void handle();
}


class ConcreteHandler extends AbstractHandler implements Handler {
    private String name;

    public ConcreteHandler(String name) {
        this.name = name;
    }

    @Override
    public void handle() {
        // 先传递给输入对象调用
        if (getHandler() != null)
            getHandler().handle();
        // 再执行当前对象调用
        System.out.println("handle" + name);
    }
}

@Data
abstract class AbstractHandler {
    private Handler handler;
}