package com.taejune.algorithm.leetcode;

import java.util.*;

// https://leetcode.com/problems/finding-the-users-active-minutes/
public class Problem1817 {
    public static class Solution {
        public int[] solution(int[][] logs, int k) {
            Map<Integer, Set<Integer>> m = new HashMap<>();
            for (int i = 0; i < logs.length; i++) {
                Set s = m.getOrDefault(logs[i][0], new HashSet<>());
                s.add(logs[i][1]);
                m.put(logs[i][0], s);
            }
            int[] answer = new int[k];
            for (int id : m.keySet()) {
                Set s = m.get(id);
                if (s != null) {
                    answer[s.size()-1]++;
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
