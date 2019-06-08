package com.exercise.Static;


class B extends Static {
    static {
        System.out.println("B.static block");
    }

    public B() {
        System.out.println("B.constructor()");
    }


    public static void main(String[] args) {
        new B();
        new B();
    }
}


public class Static {
    static {
        System.out.println("A.static block");
    }

    public Static() {
        System.out.println("A.constructor()");
    }
}