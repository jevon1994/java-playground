package datastructure;

import java.util.Arrays;

public class dicfind {
    public static void main(String[] args) {
        int[] a = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
        int b = find(100, a);
        System.out.println(b);
    }

    public static int find(int value, int[] a) {
        int min = 0;
        int max = a.length - 1;
        Arrays.sort(a);
        while (max >= min) {
            int b = (min + max) / 2;
            if (value == a[b]) {
                return b;
            }
            if (value < a[b]) {
                max = b - 1;
            }

            if (value > a[b]) {
                max = b + 1;
            }
        }
        return -1;
    }
}


