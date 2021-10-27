package com.taejune.algorithm.programmers.dfs;

import java.util.ArrayList;
import java.util.List;

// https://programmers.co.kr/learn/courses/30/lessons/43165
public class Problem01 {
    static class Solution {
        int count = 0;

        public int solution(int[] numbers, int target) {
            operate(numbers, 0, target, new ArrayList<>());
            return count;
        }

        private void operate(int[] numbers, int depth, int target, List<Integer> operands) {
            if (operands.size() == numbers.length) {
                if (operands.stream().parallel().reduce(0, (total, n) -> total + n) == target) {
                    count++;
                }
            }

            if (operands.size() < numbers.length) {
                List<Integer> plus = new ArrayList<>(operands);
                plus.add(numbers[depth]);
                operate(numbers, depth + 1, target, plus);

                List<Integer> minus = new ArrayList<>(operands);
                minus.add(-numbers[depth]);
                operate(numbers, depth + 1, target, minus);
            }
        }
    }

    public static void main(String[] args) {
        int case01 = new Solution().solution(new int[]{1, 1, 1, 1, 1}, 3);
        assert case01 == 5;
        System.out.println(case01); // 5

    }
}
