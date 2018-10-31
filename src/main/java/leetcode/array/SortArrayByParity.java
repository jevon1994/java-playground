package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class SortArrayByParity {
    public static void main(String[] args) {
        int[] A = {3, 1, 2, 4};
        List<Integer> evens = new ArrayList<>();
        List<Integer> odds = new ArrayList<>();
        for (int obj : A) {
            if (obj % 2 == 0) {
                evens.add(obj);
            } else {
                odds.add(obj);
            }
        }
        List<Integer> arrays = new ArrayList<>();
        arrays.addAll(evens);
        arrays.addAll(odds);
        int[] B = new int[A.length];
        for (int i = 0; i < B.length; i++) {
            B[i] = arrays.get(i);
            System.out.print(B[i] + " ");
        }
    }
}
