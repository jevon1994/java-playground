package com.exercise.Collection.List.arrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListForRemove {

    public static void main(String[] args) {
        ListForRemove listForRemove = new ListForRemove();
        listForRemove.fixConurrent2();
    }

    /**
     * 越界报错
     * 原因：删除后，集合长度动态改变，由于长度只获取一次，发生越界
     */
    public void IndexOutTest(){
        List<Integer> intList = new ArrayList<Integer>();
        Collections.addAll(intList, 1, 2, 3, 5, 6);
        // for循环优化写法，只获取一次长度
        for(int i = 0, size = intList.size(); i < size; i++) {
            Integer value = intList.get(i);
            // 符合条件，删除元素
            if(value == 3 || value == 5) {
                intList.remove(i);
            }
        }
        System.out.println(intList);
    }

    /**
     * 未达成要求，少删除了一个元素
     * 原因：后面的元素往前补一位，这时i=3的时候，值为6，跳过了5
     */
    public void removeLess(){
        List<Integer> intList = new ArrayList<Integer>();
        Collections.addAll(intList, 1, 2, 3, 5, 6);
        for(int i = 0; i < intList.size(); i++) {
            Integer value = intList.get(i);
            // 符合条件，删除元素
            if(value == 3 || value == 5) {
                intList.remove(i);
            }
        }
        System.out.println(intList);
    }

    /**
     * 并发修改
     * 互斥锁：Iterator 在工作的时候是不允许被迭代的对象被改变的
     */
    public void concurrentModify(){
        List<Integer> intList = new ArrayList<Integer>();
        Collections.addAll(intList, 1, 2, 3, 5, 6);
        for(Integer val : intList) {
            // 符合条件，删除元素
            if(val == 3 || val == 5) {
                intList.remove(val);
            }
        }
        System.out.println(intList);
    }

    /**
     * 自定义维护索引，删除一个元素后，索引-1
     */
    public void fixConurrent1(){
        List<Integer> intList = new ArrayList<Integer>();
        Collections.addAll(intList, 1, 2, 3, 5, 6);
        for(int i = 0; i < intList.size(); i++) {
            Integer value = intList.get(i);
            if(value == 3 || value == 5) {
                intList.remove(i);
                i--;
            }
        }
        System.out.println(intList);
    }

    /***
     * Iterator.Remove（）
     */
    public void fixConurrent2(){
        List<Integer> intList = new ArrayList<Integer>();
        Collections.addAll(intList, 1, 2, 3, 5, 6);
        Iterator<Integer> it = intList.iterator();
        while(it.hasNext()) {
            Integer value = it.next();
            if(value == 3 || value == 5) {
                it.remove();
            }
        }
        System.out.println(intList);
    }
}
