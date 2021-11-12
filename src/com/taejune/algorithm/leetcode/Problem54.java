package com.taejune.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/spiral-matrix/

public class Problem54 {
    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> path = new ArrayList<>();

            int width = matrix[0].length;
            int height = matrix.length;

            boolean[][] visit = new boolean[height][width];

            int cnt = 0;
            int x = 0;
            int y = 0;

            while (cnt++ < width * height) {
                while (go(visit, x++, y)) {
                    path.add(matrix[y][x - 1]);
                }
                x -= 2;
                y += 1;

                while (go(visit, x, y++)) {
                    path.add(matrix[y - 1][x]);
                }
                y -= 2;
                x -= 1;

                while (go(visit, x--, y)) {
                    path.add(matrix[y][x + 1]);
                }
                x += 2;
                y -= 1;

                while (go(visit, x, y--)) {
                    path.add(matrix[y + 1][x]);
                }
                y += 2;
                x += 1;
            }

            return path;
        }

        boolean go(boolean[][] visit, int x, int y) {
            if (x >= visit[0].length || y >= visit.length || x < 0 || y < 0) {
                return false;
            }

            if (!visit[y][x]) {
                System.out.println(x + ", " + y);
                visit[y][x] = true;
                return true;
            }

            return false;
        }
    }

    public static void main(String[] args) {
        List<Integer> case01 = new Solution().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        System.out.println(case01);

        List<Integer> case02 = new Solution().spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
        System.out.println(case02);

        List<Integer> case03 = new Solution().spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});
        System.out.println(case03);
    }
}
