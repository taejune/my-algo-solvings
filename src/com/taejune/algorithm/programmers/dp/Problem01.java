package com.taejune.algorithm.programmers.dp;

public class Problem01 {
    static class Solution {
        public int solution(int N, int number) {
            int answer = 0;

            // 1       | n/n        | 2
            // 11      | nn/n       | 3
            // 111     | nnn/n      | 4
            // ...
            // 111111  |  nnnnnn/n  | 7
            // 1111111 | nnnnnnn/n  | 8

            // n       | n          | 1
            // n^2     | nxn        | 2
            // n^3     | nxnxn      | 3
            // ...
            // n^7     |  nnnnnnn   | 7
            // n^8     | nnnnnnnn   | 8



            return answer;
        }
    }

    public static void main(String[] args) {
        int case01 = new Solution().solution(5, 12);
        System.out.println(case01);
        assert case01 == 4;

        int case02 = new Solution().solution(2, 11);
        System.out.println(case02);
        assert case02 == 3;
    }
}
