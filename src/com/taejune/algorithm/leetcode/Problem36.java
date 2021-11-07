package com.taejune.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/valid-sudoku/
public class Problem36 {
    final static int boardSize = 9;
    final static int subboardSize = 3;

    static class Solution {
        public boolean isValidSudoku(char[][] board) {
            // Rule 1.
            if (hasRowRepetition(board)) {
                return false;
            }
            // Rule 2.
            if (hasColumnRepetition(board)) {
                return false;
            }
            // Rule 3.
            if (hasSubboxRepetition(board)) {
                return false;
            }

            return true;
        }

        private boolean hasRowRepetition(char[][] board) {
            for (int i = 0; i < boardSize; i++) {
                Set<Character> s = new HashSet<>();
                for (int j = 0; j < boardSize; j++) {
                    if (board[i][j] != '.') {
                        if (s.contains(board[i][j])) {
                            return true;
                        }
                        s.add(board[i][j]);
                    }
                }
            }
            return false;
        }

        private boolean hasColumnRepetition(char[][] board) {
            for (int i = 0; i < boardSize; i++) {
                Set<Character> s = new HashSet<>();
                for (int j = 0; j < boardSize; j++) {
                    if (board[j][i] != '.') {
                        if (s.contains(board[j][i])) {
                            return true;
                        }
                        s.add(board[j][i]);
                    }
                }
            }
            return false;
        }

        private boolean hasSubboxRepetition(char[][] board) {
            for (int xoff = 0; xoff <= 6; xoff += 3) {
                for (int yoff = 0; yoff <= 6; yoff += 3) {
                    Set<Character> s = new HashSet<>();
                    for (int i = 0; i < subboardSize; i++) {
                        for (int j = 0; j < subboardSize; j++) {
                            int x = i + xoff;
                            int y = j + yoff;
                            if (board[x][y] != '.') {
                                if (s.contains(board[x][y])) {
                                    return true;
                                }
                                s.add(board[x][y]);
                            }
                        }
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("case01");
        boolean case01 = new Solution().isValidSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}});
        assert case01 == true;

        System.out.println("case02");
        boolean case02 = new Solution().isValidSudoku(new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}});
        assert case02 == false;
    }
}
