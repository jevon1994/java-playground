package com.exercise;

import lombok.Data;

public class TestExtends {
    public static <T extends Parent> String unpass(T t){
        return t.getName();
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        System.out.println(unpass(sub));
    }
}

@Data
class Parent {
    private String name = "1";
    private String age = "2";
}

@Data
class Sub extends  Parent{
    private String name = "3";
    private String age = "4";
}

