package com.datastructure.list;

import java.util.Arrays;

public class dicfind {
    static int count;
    public static void main(String[] args) {
        int[] a = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
        Arrays.sort(a);
        System.out.println(find(2, a) + "  " + count);
        System.out.println(find(2, a) + "  " + count);
    }

    /**
     * 递归实现
     *
     * @param value
     * @param a
     * @param start
     * @param end
     * @return
     */
    public static int fibFind(int value, int[] a, int start, int end) {
        while (end >= start) {
            count++;
            int mid = (start + end) / 2;
            if (value == a[mid]) {
                return mid;
            }
            // 前半段
            if (value < a[mid]) {
                return fibFind(value, a, start, mid - 1);
            }
            // 后半段
            if (value > a[mid]) {
                return fibFind(value, a, start, mid + 1);
            }
        }
        return -1;
    }

    /**
     * 循环二分法
     *
     * @param value
     * @param a
     * @return 返回第一次出现值的位置
     */
    public static int find(int value, int[] a) {
        count++;
        int start = 0;
        int end = a.length - 1;
        while (end >= start) {
            // 中间位值
            int mid = (start + end) / 2;
            if (value == a[mid]) {
                return mid;
            }
            // 前半段
            if (value < a[mid]) {
                end = mid - 1;
            }
            // 后半段
            if (value > a[mid]) {
                start = mid + 1;
            }
        }
        return -1;
    }
}


