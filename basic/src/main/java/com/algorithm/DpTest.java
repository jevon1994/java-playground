package com.algorithm;

import java.util.Arrays;

public class DpTest {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(fib(n));
        System.out.println(fib2(n));
        System.out.println(fib3(n));
        System.out.println(fib4(n));
    }

    // 1
    public static int fib(int n) {
        if (n == 1 || n == 2) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    // 2 memo
    public static int fib2(int n) {
        if (n < 1) return 0;
        int[] memo = new int[n + 1];
        Arrays.fill(memo, 0);
        memo[1] = memo[2] = 1;
        return helper(memo, n);
    }

    public static int helper(int[] memo, int n) {
        if (n > 0 && memo[n] == 0)
            memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];
    }

    // 3 dp table
    public static int fib3(int n) {
        int[] dp = new int[n + 1];
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // 4 without store
    public static int fib4(int n) {
        if (n < 1) return 0;
        int pre = 0, curr = 1;
        for (int i = 0; i < n - 1; i++) {
            int sum = pre + curr;
            pre = curr;
            curr = sum;
        }
        return curr;
    }
}
