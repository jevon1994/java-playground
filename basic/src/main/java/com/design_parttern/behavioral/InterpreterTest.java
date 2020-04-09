package com.design_parttern.behavioral;

import lombok.AllArgsConstructor;
import lombok.Data;

public class InterpreterTest {
    public static void main(String[] args) {
        // 2+2-1
        int interpreter = new Plus().interpreter(new Context(2, new Minus().interpreter(
                new Context(2, 1)
        )));
        System.out.println(interpreter);
    }
}


abstract class AbstractExpression {
    abstract int interpreter(Context context);
}

class Minus extends AbstractExpression {
    @Override
    int interpreter(Context context) {
        return context.getA() - context.getB();
    }
}

class Plus extends AbstractExpression {
    @Override
    int interpreter(Context context) {
        return context.getB() + context.getA();
    }
}

@Data
@AllArgsConstructor
class Context {
    private int a;
    private int b;
}