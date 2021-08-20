package com.taejune.algorithm.programmers.fullsearch;

import java.util.*;

public class Problem01 {

    static class Solution {
        public int[] solution(int[] answers) {
            int[][] solves = new int[][]{
                    new int[]{1, 2, 3, 4, 5},
                    new int[]{2, 1, 2, 3, 2, 4, 2, 5},
                    new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
            };

            int[] scores = new int[]{0, 0, 0};
            for (int i = 0; i < answers.length; i++) {
                for (int j = 0; j < solves.length; j++) {
                    int idx = i % solves[j].length;
                    if (answers[i] == solves[j][idx]) {
                        scores[j]++;
                    }
                }
            }

            int bestScore = 0;
            Map<Integer, List<Integer>> tbl = new HashMap<>();
            for (int i = 0; i < scores.length; i++) {
                List sameScored = tbl.getOrDefault(scores[i], new ArrayList<>());
                sameScored.add(i + 1);
                tbl.put(scores[i], sameScored);
                if (bestScore < scores[i]) {
                    bestScore = scores[i];
                }
            }

            List<Integer> bests = tbl.get(bestScore);
            int[] res = new int[bests.size()];
            for (int i = 0; i < res.length; i++) {
                res[i] = bests.get(i);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] case01 = new int[]{1, 2, 3, 4, 5};
        int[] answer01 = new Solution().solution(case01);
        for (int i = 0; i < answer01.length; i++) {
            System.out.println(answer01[i]);
        }

        int[] case02 = new int[]{1, 3, 2, 4, 2};
        int[] answer02 = new Solution().solution(case02);

        for (int i = 0; i < answer02.length; i++) {
            System.out.println(answer02[i]);
        }
    }
}
