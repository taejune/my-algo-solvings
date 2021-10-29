package com.taejune.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/generate-parentheses/
public class Problem22 {
    static class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> answer = new ArrayList<>();
            char[] m = new char[n * 2];
            build(m, 0, 0, 0, 0, n, answer);
            return answer;
        }

        private void build(char[] tokens, int idx, int sum, int open, int close, int target, List<String> save) {
            if (idx > tokens.length || open > target || close > target || sum < 0 || sum > target) {
                return;
            }
            if (open == target && open == close) {
                save.add(String.valueOf(tokens));
                return;
            }
            tokens[idx] = '(';
            build(tokens.clone(), idx + 1, sum + 1, open + 1, close, target, save);
            tokens[idx] = ')';
            build(tokens.clone(), idx + 1, sum - 1, open, close + 1, target, save);
        }
    }

    public static void main(String[] args) {
        List<String> case01 = new Solution().generateParenthesis(3);
        System.out.println(case01); // should be ["((()))","(()())","(())()","()(())","()()()"]

        List<String> case02 = new Solution().generateParenthesis(1);
        System.out.println(case02); // should be ["()"]

    }
}
