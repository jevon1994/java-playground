package com.design_parttern.creation;

public class Singleton {

    private static final class inner {
        private static final Singleton instance = new Singleton();
    }

    private Singleton() {
    }

    private static Singleton getInstance() {
        return inner.instance;
    }
}
