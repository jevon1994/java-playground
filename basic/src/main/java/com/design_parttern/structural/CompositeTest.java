package com.design_parttern.structural;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class CompositeTest {
    public static void main(String[] args) {
        AbstractComponent tree = new Tree("1", "parent");
        AbstractComponent sub2 = new TreeNode("2", "sub2");
        AbstractComponent sub3 = new TreeNode("3", "sub3");
        sub2.add(sub3);
        tree.add(sub2);
        tree.print();
        sub2.print();
        sub3.print();

    }
}

interface AbstractComponent {
    void add(AbstractComponent abstractComponent);

    void print();
}

@Data
class Tree implements AbstractComponent {
    private String layer;
    private String name;
    private List<AbstractComponent> children = new ArrayList();

    public Tree(String layer, String name) {
        this.name = name;
        this.layer = layer;
    }

    @Override
    public void add(AbstractComponent abstractComponent) {
        this.children.add(abstractComponent);
    }

    @Override
    public void print() {
        System.out.println(layer + "|----|" + name);
    }
}

@Data
class TreeNode implements AbstractComponent {
    private String layer;
    private String name;
    private List<AbstractComponent> children = new ArrayList();

    public TreeNode(String layer, String name) {
        this.name = name;
        this.layer = layer;
    }

    @Override
    public void add(AbstractComponent abstractComponent) {
        this.children.add(abstractComponent);
    }

    @Override
    public void print() {
        System.out.println(layer + "|----|" + name);
    }
}
