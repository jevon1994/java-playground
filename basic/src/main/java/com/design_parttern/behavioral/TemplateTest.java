package com.design_parttern.behavioral;

public class TemplateTest {
    public static void main(String[] args) {
        TemplateInvoke invoke = new TemplateInvoke();
        invoke.out();
    }
}


abstract class Template {

    abstract String temp();

    public void out() {
        System.out.printf("==================" + temp()+ "=================  ");
    }
}


class TemplateInvoke extends Template {

    @Override
    String temp() {
        return "template";
    }
}