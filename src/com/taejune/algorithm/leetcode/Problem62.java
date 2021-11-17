package com.taejune.algorithm.leetcode;

// https://leetcode.com/problems/unique-paths/
public class Problem62 {
    static class Solution {
        int[][] matrix;
        public int uniquePaths(int m, int n) {
            matrix = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = -1;
                }
            }
            return paths(m, n);
        }
        int paths(int m, int n) {
            int x = n - 1;
            int y = m - 1;
            if (matrix[y][x] == -1) {
                if (x == 0 || y == 0) {
                    matrix[y][x] = 1;
                } else {
                    matrix[y][x] = paths(m - 1, n) + paths(m, n - 1);
                }
            }
//            System.out.println(x + ", " + y + " = " + matrix[y][x]);
            return matrix[y][x];
        }
    }

    public static void main(String[] args) {
        int case01 = new Solution().uniquePaths(3, 7);
        assert case01 == 28;
        System.out.println(case01);

        int case02 = new Solution().uniquePaths(3, 2);
        assert case02 == 3;
        System.out.println(case02);

        int case03 = new Solution().uniquePaths(7, 3);
        assert case03 == 28;
        System.out.println(case03);

        int case04 = new Solution().uniquePaths(3, 3);
        assert case04 == 6;
        System.out.println(case04);
    }
}
