package com.taejune.algorithm.leetcode;

// https://leetcode.com/problems/rotate-image/
public class Problem48 {
    static class Solution {
        public void rotate(int[][] matrix) {
            skew(matrix);
            decalcomani(matrix);
        }

        void skew(int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = i + 1; j < matrix[i].length; j++) {
                    swap(matrix, i, j, j, i);
                }
            }
        }

        void decalcomani(int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length / 2; j++) {
                    swap(matrix, i, j, i, matrix[i].length - 1 - j);
                }
            }
        }

        void swap(int[][] matrix, int x, int y, int tox, int toy) {
            int tmp = matrix[x][y];
            matrix[x][y] = matrix[tox][toy];
            matrix[tox][toy] = tmp;
        }
    }

    public static void main(String[] args) {
        int[][] case01 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new Solution().rotate(case01);
        print(case01);

        int[][] case02 = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        new Solution().rotate(case02);
        print(case02);

        int[][] case03 = new int[][]{{1}};
        new Solution().rotate(case03);
        print(case03);

        int[][] case04 = new int[][]{{1, 2}, {3, 4}};
        new Solution().rotate(case04);
        print(case04);
    }

    static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%2d ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
