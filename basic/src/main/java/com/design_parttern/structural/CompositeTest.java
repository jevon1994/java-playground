package com.design_parttern.structural;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class CompositeTest {
    public static void main(String[] args) {
        Tree tree = new Tree("A");
        TreeNode childA = new TreeNode("B");
        TreeNode childB = new TreeNode("C");
        childB.getChildren().add(childA);
        tree.setTreeNode(childB);
    }
}

@Data
class Tree {
    private TreeNode treeNode;

    public Tree(String name) {
        treeNode = new TreeNode(name);
    }
}

@Data
class TreeNode {
    private TreeNode treeNode;
    private String name;
    private List<TreeNode> children = new ArrayList();

    public TreeNode(String name) {
        this.name = name;
    }

    public void addChild(TreeNode treeNode) {
        children.add(treeNode);
    }

    public void removeChild(TreeNode node) {
        children.remove(node);
    }
}
