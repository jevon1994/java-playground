package com.playground.datastructure.List.linkedList;

import java.util.LinkedList;

/**
 * 堆栈 -- 后进先出（LIFO）
 * 双向链表 -- 先进后出（FILO）
 * linkedlist 实现 堆栈(栈) stack
 */
public class StringStack {

    private LinkedList<String> linkedList = new LinkedList<String>();

    /**
     * 将元素加入LinkedList容器
     * (即插入到链表的第一个位置)
     */
    public void push(String name) {
        linkedList.addFirst(name);
    }

    /**
     * 取出堆栈中最上面的元素
     * (即取出链表linkedList的第一个元素)
     *
     * @return
     */
    public String getTop() {
        return linkedList.getFirst();
    }

    /**
     * 取出并删除最上面的元素
     * (即移出linkedList的第一个元素)
     *
     * @return
     */
    public String pop() {
        return linkedList.removeFirst();
    }

    /**
     * 获取元素个数
     *
     * @return
     */
    public int size() {
        return linkedList.size();
    }

    /**
     * 判断堆栈是否为空
     * (即判断 linkedList是否为空)
     *
     * @return
     */
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    //测试
    public static void main(String[] args) {
        StringStack stack = new StringStack();
        stack.push("yulon");
        stack.push("xiaoyun");
        stack.push("羽龙共舞");
        System.out.print("第一个元素是:\t");
        System.out.println(stack.getTop());
        System.out.println();
        System.out.println("全部元素:");
        while (!stack.isEmpty()) {
            System.out.println("\t" + stack.pop());
        }
    }


}
