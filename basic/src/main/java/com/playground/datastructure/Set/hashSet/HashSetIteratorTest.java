package com.playground.datastructure.Set.hashSet;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetIteratorTest {
    public static void main(String[] args) {
        // 新建HashSet
        HashSet set = new HashSet();

        // 添加元素 到HashSet中
        for (int i = 0; i < 5; i++)
            set.add("" + i);

        // 通过Iterator遍历HashSet
        iteratorHashSet(set);

        // 通过for-each遍历HashSet
        foreachHashSet(set);
    }

    /*
     * 通过Iterator遍历HashSet。推荐方式
     */
    private static void iteratorHashSet(HashSet set) {
        long start = System.currentTimeMillis();
        for (Iterator iterator = set.iterator();
             iterator.hasNext(); ) {
            System.out.printf("iterator : %s\n", iterator.next());
        }
        long end = System.currentTimeMillis();
        long interval = end - start;
        System.out.println(interval);
    }

    /*
     * 通过for-each遍历HashSet。不推荐！此方法需要先将Set转换为数组
     */
    private static void foreachHashSet(HashSet set) {

        String[] arr = (String[]) set.toArray(new String[0]);
        long start = System.currentTimeMillis();
        for (String str : arr)
            System.out.printf("for each : %s\n", str);
        long end = System.currentTimeMillis();
        long interval = end - start;
        System.out.println(interval);
    }
}