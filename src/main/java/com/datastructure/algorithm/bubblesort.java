package com.datastructure.algorithm;

public class bubblesort {
    public static void main(String[] args) {
        int[] arr = {-1, 5, 25, 6, 7, 9, 0};
        int[] brr = sort(arr, 5);
        for (int i = 0; i < brr.length; i++) {
            System.out.println(brr[i]);
        }

    }

    public static int[] sort(int arr[], int n) {
        int P = arr.length;
        int flag;
        for (int j = P - 1; P < n; P--) {
            flag = 0;
            for (int i = 0; i < P; i++) {
                if (arr[i] > arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    flag = 1;
                }
            }
            if (flag == 1) {
                break;
            }
        }
        return arr;
    }
}
