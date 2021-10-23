package com.taejune.algorithm.programmers.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://programmers.co.kr/learn/courses/30/lessons/49189?language=java
public class Problem01 {
    static class Solution {
        public int solution(int n, int[][] edge) {
            boolean[][] m = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    m[i][j] = false;
                }
            }
            for (int i = 0; i < edge.length; i++) {
                m[edge[i][0] - 1][edge[i][1] - 1] = true;
                m[edge[i][1] - 1][edge[i][0] - 1] = true;
            }

            print(m);
            int[] dist = new int[n];
            Map<Integer, Boolean> visit = new HashMap<Integer, Boolean>();
            for (int i = 0; i < m[0].length; i++) {
                visit.put(i, false);
            }
            visit.put(0, true);
            for (int i = 0; i < m[0].length; i++) {
                if (m[0][i]) {
                    dist[i] = 1;
                    setDist(m, i, 1, dist, visit);
                }
            }

            for (int d : dist) {
                System.out.printf("%d ", d);
            }
            System.out.println();

            int max = Arrays.stream(dist).max().getAsInt();
            if (max == 0) {
                return 0;
            }
            return Arrays.stream(dist).filter(value -> value == max).toArray().length;
        }

        void setDist(boolean[][] m, int from, int depth, int[] dist, Map<Integer, Boolean> visit) {
            System.out.println("visit node: " + from);
            for (int i = 0; i < m[from].length; i++) {
                if (m[from][i] && !visit.get(i)) {
                    if (dist[i] == 0) {
                        dist[i] = depth + 1;
                    }
                    dist[i] = Math.min(dist[i], depth + 1);
                    visit.put(i, true);
                }
            }

            for (int i = 0; i < m[from].length; i++) {
                if (m[from][i] && !visit.get(i)) {
                    setDist(m, i, depth + 1, dist, visit);
                }
            }
        }

        void print(boolean[][] m) {
            for(int i=0; i<m.length; i++) {
                for(int j=0; j<m[i].length; j++) {
                    if(m[i][j]) {
                        System.out.print("1 ");
                    } else {
                        System.out.print("0 ");
                    }
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
//        int case01 = new Solution().solution(6, new int[][]{new int[]{3, 6}, new int[]{4, 3}, new int[]{3, 2},
//                new int[]{1, 3}, new int[]{1, 2}, new int[]{2, 4}, new int[]{5, 2}});
//        System.out.println("case01: " + case01);
//        assert case01 == 3;
//
//        int case02 = new Solution().solution(4, new int[][]{new int[]{1, 2}, new int[]{1, 3}, new int[]{1, 4}});
//        System.out.println("case02: " + case02);
//        assert case02 == 3;
//
//        int case03 = new Solution().solution(3, new int[][]{new int[]{1, 2}, new int[]{2, 3}});
//        System.out.println("case03: " + case03);
//        assert case03 == 1;
//
//        int case04 = new Solution().solution(5, new int[][]{new int[]{1, 2}, new int[]{2, 3}, new int[]{2, 4}, new int[]{2, 5}});
//        System.out.println("case04: " + case04);
//        assert case04 == 3;
//
//        int case05 = new Solution().solution(4, new int[][]{new int[]{1, 2}, new int[]{1, 3}, new int[]{1, 4}, new int[]{2, 4}});
//        System.out.println("case05: " + case05);
//        assert case05 == 3;
//
//        int case06 = new Solution().solution(7, new int[][]{new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4}, new int[]{4, 5}, new int[]{4, 6}, new int[]{4, 7}, new int[]{1, 7}});
//        System.out.println("case06: " + case06);
//        assert case06 == 2;
//
//        int case07 = new Solution().solution(3, new int[][]{new int[]{2, 3}});
//        System.out.println("case07: " + case07);
//        assert case07 == 0;
//
//        int case08 = new Solution().solution(7, new int[][]{new int[]{1, 2}, new int[]{3, 4}, new int[]{4, 5}, new int[]{4, 6}, new int[]{4, 7}});
//        System.out.println("case08: " + case08);
//        assert case08 == 1;

        int case09 = new Solution().solution(7, new int[][]{new int[]{1, 2}, new int[]{3, 4}, new int[]{4, 5}, new int[]{4, 6}, new int[]{4, 7}, new int[]{2, 7}});
        System.out.println("case09: " + case09);
        assert case09 == 3;

        int case10 = new Solution().solution(7, new int[][]{new int[]{3, 6}, new int[]{4, 3}, new int[]{3, 2},
                new int[]{1, 3}, new int[]{1, 2}, new int[]{2, 4}, new int[]{5, 2}, new int[]{5, 7}});
        System.out.println("case10: " + case10);
        assert case10 == 1;
    }
}
