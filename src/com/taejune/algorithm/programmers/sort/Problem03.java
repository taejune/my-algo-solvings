package com.taejune.algorithm.programmers.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Problem03 {

    public static class Solution {

        public int solution(int[] citations) {
            int answer = 0;

            List<Integer> c = Arrays.stream(citations).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

            for (int i = 0; i < citations.length; i++) {
                if (c.get(i) >= i + 1) {
                    answer = i + 1;
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {

        int case01 = new Solution().solution(new int[]{3, 0, 6, 1, 5});
        System.out.println(case01); // 3

        int case02 = new Solution().solution(new int[]{2, 2});
        System.out.println(case02); // 2

        int case03 = new Solution().solution(new int[]{4, 0});
        System.out.println(case03); // 1

        int case04 = new Solution().solution(new int[]{4, 4, 4, 3});
        System.out.println(case04); // 3
    }
}
