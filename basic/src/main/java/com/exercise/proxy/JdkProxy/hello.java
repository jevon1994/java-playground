package com.exercise.proxy.JdkProxy;


public class hello {
    public static void main(String[] args) {
        MyInvocationHandler demo = new MyInvocationHandler();
        Subject sub = (Subject) demo.bind(new RealSubject());
        String info = sub.say("Rollen", 20);
//        System.out.println(info);
//        System.out.println(info.hashCode());
        System.out.println(sub.hashCode());
    }
}