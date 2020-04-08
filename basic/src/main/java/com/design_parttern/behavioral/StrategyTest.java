package com.design_parttern.behavioral;

public class StrategyTest {
    public static void main(String[] args) {
        StrategyService strategyImplA = new StrategyImplA();
        StrategyService strategyImplB = new StrategyImplB();
        StrategyUse strategyUseA = new StrategyUse(strategyImplA);
        strategyUseA.invoke();
        StrategyUse strategyUseB = new StrategyUse(strategyImplB);
        strategyUseB.invoke();

    }
}


interface StrategyService {
    void testMethod();
}


class StrategyImplA implements StrategyService {
    @Override
    public void testMethod() {
        System.out.println("A");
    }
}


class StrategyImplB implements StrategyService {
    @Override
    public void testMethod() {
        System.out.println("B");
    }
}

class StrategyUse {
    private StrategyService strategyService;

    public StrategyUse(StrategyService strategyService) {
        this.strategyService = strategyService;
    }

    public void invoke() {
        strategyService.testMethod();
    }
}