package com.taejune.algorithm.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/flood-fill/
public class Problem733 {
    static class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            int oldColor = image[sr][sc];
            boolean[][] hasVisited = new boolean[image.length][image[0].length];
            perForm(image, sr, sc, oldColor, newColor, hasVisited);
            return image;
        }

        void perForm(int[][] image, int sr, int sc, int oldColor, int newColor, boolean[][] hasVisit) {
            if (!canPerform(image, sr, sc, oldColor) || hasVisit[sr][sc]) {
                return;
            }
            image[sr][sc] = newColor;
            hasVisit[sr][sc] = true;

            perForm(image, sr - 1, sc, oldColor, newColor, hasVisit);
            perForm(image, sr, sc + 1, oldColor, newColor, hasVisit);
            perForm(image, sr + 1, sc, oldColor, newColor, hasVisit);
            perForm(image, sr, sc - 1, oldColor, newColor, hasVisit);
        }

        boolean canPerform(int[][] image, int sr, int sc, int color) {
            return sr >= 0 && sc >= 0 && sr <= image.length - 1 && sc <= image[0].length - 1 && image[sr][sc] == color;
        }
    }

    public static void main(String[] args) {
        int[][] case01 = new Solution().floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2);
        for (int i = 0; i < case01.length; i++) {
            for (int j = 0; j < case01[i].length; j++) {
                System.out.print(case01[i][j] + ",");
            }
            System.out.println();
        }

        int[][] case02 = new Solution().floodFill(new int[][]{{0, 0, 0,}, {0, 0, 0}}, 0, 0, 2);
        for (int i = 0; i < case02.length; i++) {
            for (int j = 0; j < case02[i].length; j++) {
                System.out.print(case02[i][j] + ",");
            }
            System.out.println();
        }
    }
}
