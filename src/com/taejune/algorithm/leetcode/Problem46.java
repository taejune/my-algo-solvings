package com.taejune.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem46 {
    static class Solution {
        List<List<Integer>> answer = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            permutation(Arrays.stream(nums).boxed().collect(Collectors.toList()), new ArrayList<>(), nums.length);
            return answer;
        }

        void permutation(List<Integer> elements, List<Integer> saved, int len) {
            if (elements.isEmpty() && saved.size() == len) {
                answer.add(saved);
                return;
            }

            for (int i = 0; i < elements.size(); i++) {
                List<Integer> copy = new ArrayList<>(elements);
                int n = copy.remove(i);
                List<Integer> savedcopy = new ArrayList<>(saved);
                savedcopy.add(n);
                permutation(copy, savedcopy, len);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> case01 = new Solution().permute(new int[]{1, 2, 3});
        System.out.println("case01");
        for (List<Integer> l : case01) {
            System.out.println(l);
        }

        List<List<Integer>> case02 = new Solution().permute(new int[]{0, 1});
        System.out.println("case02");
        for (List<Integer> l : case02) {
            System.out.println(l);
        }

        System.out.println("case03");
        List<List<Integer>> case03 = new Solution().permute(new int[]{1});
        for (List<Integer> l : case03) {
            System.out.println(l);
        }
    }

}
