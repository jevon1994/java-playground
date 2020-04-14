package com.design_parttern.behavioral;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class IteratorTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList() {{
            add("1");
            add("2");
        }};
        Aggregate aggregate = new SelfAggerator(list);
        Iterator iterator = aggregate.createIterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}


interface Iterator {

    Object next();

    boolean hasNext();

}

interface Aggregate {
    Iterator createIterator();

    Object get(int i);

    int size();
}


class SelfIterator implements Iterator {
    private Aggregate aggregate;

    public SelfIterator(Aggregate aggregate) {
        this.aggregate = aggregate;
    }

    private int size = -1;

    @Override
    public Object next() {
        if (aggregate.size() - 1 > size) {
            size++;
        }
        return aggregate.get(size);
    }

    @Override
    public boolean hasNext() {
        if (aggregate.size() - 1 > size) {
            return true;
        }
        return false;
    }
}

@AllArgsConstructor
class SelfAggerator implements Aggregate {
    private List list;

    @Override
    public Iterator createIterator() {
        return new SelfIterator(this);
    }

    @Override
    public Object get(int i) {
        return list.get(i);
    }

    @Override
    public int size() {
        return list.size();
    }
}