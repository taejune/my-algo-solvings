package com.taejune.algorithm.leetcode;

public class NthTribonacciNumber {

    static class Solution {

        private int[] memo;

        public Solution() {
            memo = new int[38];
            memo[0] = 0;
            memo[1] = 1;
            memo[2] = 1;
        }

        public int tribonacci(int n) {
            int tn_1;
            int tn_2;
            int tn_3;

            if (n < 3) {
                return memo[n];
            } else {
                if (memo[n - 1] != 0) {
                    tn_1 = memo[n - 1];
                } else {
                    tn_1 = tribonacci(n - 1);
                }

                if (memo[n - 2] != 0) {
                    tn_2 = memo[n - 2];
                } else {
                    tn_2 = tribonacci(n - 2);
                }

                if (memo[n - 3] != 0) {
                    tn_3 = memo[n - 3];
                } else {
                    tn_3 = tribonacci(n - 3);
                }

                memo[n] = tn_1 + tn_2 + tn_3;
                return memo[n];
            }
        }
    }

    public static void main(String[] args) {

        int case01 = new Solution().tribonacci(1);
        System.out.println(case01);

        int case02 = new Solution().tribonacci(2);
        System.out.println(case02);

        int case03 = new Solution().tribonacci(3);
        System.out.println(case03);

        int case04 = new Solution().tribonacci(4);
        System.out.println(case04);

        int case05 = new Solution().tribonacci(5);
        System.out.println(case05);
    }
}
