package com.taejune.algorithm.leetcode;

import java.util.*;

// https://leetcode.com/problems/all-paths-from-source-to-target/
public class Problem797 {
    public static class Solution {
        public List<List<Integer>> solution(int[][] graph) {
            boolean[][] m = new boolean[graph.length][graph.length];
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph[i].length; j++) {
                    m[i][graph[i][j]] = true;
                }
            }

            List<List<Integer>> answer = new ArrayList<>();
            traverse(m, 0, graph.length - 1, new boolean[graph.length], new ArrayList<>(), answer);
            return answer;
        }

        private void traverse(boolean[][] map, int from, int to, boolean[] visit, List<Integer> route, List<List<Integer>> save) {
            visit[from] = true;
            route.add(from);
            if (from == to) {
                save.add(route);
                return;
            }

            for (int i = 0; i < map[from].length; i++) {
                if (!map[from][i] || visit[i]) {
                    continue;
                }
                traverse(map, i, to, visit.clone(), new ArrayList<>(route), save);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> case01 = new Solution().solution(new int[][]{{1, 2}, {3}, {3}, {}});
        System.out.println(case01);
//        int[][] correct01 = new int[][]{{0, 1, 3}, {0, 2, 3}};


        List<List<Integer>> case02 = new Solution().solution(new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}});
        System.out.println(case02);
//        int[][] correct02 = new int[][]{{0, 4}, {0, 3, 4}, {0, 1, 3, 4}, {0, 1, 2, 3, 4}, {0, 1, 4}};
    }
}
