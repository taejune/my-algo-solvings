package com.taejune.algorithm.leetcode;

import java.util.*;

// https://leetcode.com/problems/finding-the-users-active-minutes/
public class Problem1817 {
    public static class Solution {
        public int[] solution(int[][] logs, int k) {
            Map<Integer, Set<Integer>> userActiveMinutes = new HashMap<>();
            for (int i = 0; i < logs.length; i++) {
                Set activeMinutes = userActiveMinutes.getOrDefault(logs[i][0], new HashSet<>());
                activeMinutes.add(logs[i][1]);
                userActiveMinutes.put(logs[i][0], activeMinutes);
            }
            int[] answer = new int[k];
            for (int userID : userActiveMinutes.keySet()) {
                Set activeMinutes = userActiveMinutes.get(userID);
                if (activeMinutes != null) {
                    answer[activeMinutes.size()-1]++;
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        int[] case01 = new Solution().solution(new int[][]{{0, 5}, {1, 2}, {0, 2}, {0, 5}, {1, 3}}, 5);
        int[] solve01 = new int[]{0, 2, 0, 0, 0};
        assert Arrays.equals(case01, solve01);

        int[] case02 = new Solution().solution(new int[][]{{1, 1}, {2, 2}, {2, 3}}, 4);
        int[] solve02 = new int[]{1, 1, 0, 0};
        assert Arrays.equals(case02, solve02);
    }

}
