package com.datastructure.array;

import java.util.Scanner;

public class MaxSumSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        new Test().maxSubseqSumWithNum(arr,N);
    }
}

class Test {
    /**
     * @param a
     * @param n
     * @return
     */
    public void maxSubseqSumWithNum(int[] a, int n) {
        int oldsum = a[0];    //前面所有数字的总和
        int start = 0;        //序列第一个数字
        int maxstart = 0;    //记录最大总和时候的开始数字
        int end = 0;            //序列最末数字（同时也是最大总和时候的最末数字）
        int newsum;        //包含当前数字的新总和
        int maxsum = Integer.MIN_VALUE;    //用来记录最大总和

        for (int i = 1; i < n; i++) {
            // 前面的和<0，那么当前数作为start重新开始一个序列
            if (oldsum < 0) {
                start = a[i];    //当前数字作为序列第一个数
                oldsum = 0;    //所以之前的总和清0咯
            }

            newsum = oldsum + a[i];
            oldsum = newsum;      //下一次遍历时候的oldsum就是这次的newsum
            // 前面的和>=0
            if (newsum > maxsum) {      //更新并存储下最大和时候的数据
                maxsum = newsum;
                end = a[i];
                maxstart = start;
            }
        }
        if (maxsum < 0) {
            System.out.println(0 + " " + a[0] + " " + a[n - 1]);
        } else
            System.out.println(maxsum + " " + maxstart + " " + end);

    }

    public void maxSubseqSum(int A[], int N) {
        int thisSum = 0;
        int maxSum = 0;
        int i;
        for (i = 0; i < N; i++) {
            thisSum += A[i];
            if (thisSum > maxSum)
                maxSum = thisSum;
            else if (thisSum < 0)
                thisSum = 0;
        }
        System.out.println(maxSum);
    }
}