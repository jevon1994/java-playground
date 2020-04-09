package com.design_parttern.behavioral;

import java.util.Observable;
import java.util.Observer;

public class ObserverTest {
    public static void main(String[] args) {
        // 被观察者
        SelfObservable selfObservable = new SelfObservable(1);
        //观察者
        SelfObserver selfObserverA = new SelfObserver("A");
        SelfObserver selfObserverB = new SelfObserver("B");
        selfObservable.addObserver(selfObserverA);
        selfObservable.addObserver(selfObserverB);
        System.out.println(selfObservable);
        selfObservable.setCount(2);
        System.out.println(selfObservable);
    }
}

class SelfObserver implements Observer {
    private String name ;

    public SelfObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(name + "=====" + arg);
    }
}


class SelfObservable extends Observable {
    private int count;

    public SelfObservable(int count) {
        this.count = count;
    }


    public void setCount(int count) {
        setChanged();
        notifyObservers(count);
        this.count = count;
    }

    @Override
    public String toString() {
        return "count值为" + count;
    }
}