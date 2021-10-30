package com.taejune.algorithm.naver.financial;

public class Problem02 {
    static class Solution {
        public int[] solution(int n, int jump) {
            int[] answer = {};
            return answer;
        }
    }

    public static void main(String[] args) {
        int[] case01 = new Solution().solution(5, 3);
        System.out.printf("(%d, %d)", case01[0], case01[1]); // expect 5,2

        int[] case02 = new Solution().solution(4, 1);
        System.out.printf("(%d, %d)", case02[0], case02[1]); // expect 3,2

        int[] case03 = new Solution().solution(3, 10);
        System.out.printf("(%d, %d)", case03[0], case03[1]); // expect 2,1
    }
}
