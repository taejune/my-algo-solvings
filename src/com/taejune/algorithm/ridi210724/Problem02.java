package com.taejune.algorithm.ridi210724;

/*
자연수 n이 주어졌을 때 3과 5의 조합으로 만들 수 있으면 최소 조합으로 만들었을 때 개수, 불가능하면 -1
 */

public class Problem02 {
    public static class Solution {
        public int solution(int n) {
            if (n > 5) {
                int a = solution(n - 5);
                if (a == -1) {
                    int b = solution(n - 3);
                    if (b == -1) {
                        return -1;
                    }
                    return b + 1;
                }
                return a + 1;
            } else if (n == 5) {
                return 1;
            } else if (n == 4) {
                return -1;
            } else if (n == 3) {
                return 1;
            } else if (n < 3) {
                return -1;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(18)); // 4
        System.out.println(new Solution().solution(11)); // 3
        System.out.println(new Solution().solution(8)); // 2
        System.out.println(new Solution().solution(7)); // -1
        System.out.println(new Solution().solution(5)); // 1
    }
}
