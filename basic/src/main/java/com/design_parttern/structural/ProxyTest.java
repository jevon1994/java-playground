package com.design_parttern.structural;

public class ProxyTest {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.invoke();
    }
}

interface Source {
    void invoke();
}

class Sourceable implements Source {

    @Override
    public void invoke() {
        System.out.println("real invoke");
    }
}

class Proxy implements Source {

    @Override
    public void invoke() {
        before();
        Sourceable sourceable = new Sourceable();
        sourceable.invoke();
        after();
    }

    private void after() {
        System.out.println("after");
    }

    private void before() {
        System.out.println("before");
    }
}