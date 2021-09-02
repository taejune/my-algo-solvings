package com.taejune.algorithm.programmers.dfs;

import java.util.ArrayList;
import java.util.List;

public class Problem01 {

    static class Solution {
        public int solution(int[] numbers, int target) {
            int answer = 0;

            List<Integer> candidates = new ArrayList<>();
            candidates.add(0);

            for(int i=0; i<numbers.length; i++) {
                List<Integer> tmp = new ArrayList<>();
                for(int candidate : candidates) {
                    tmp.add(candidate + numbers[i]);
                    tmp.add(candidate - numbers[i]);
                }
                candidates = tmp;
            }

            for(int candidate : candidates) {
                if(target == candidate) {
                    answer++;
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {

        int case01 = new Solution().solution(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println(case01); // 5
        assert case01 == 5;

    }
}
