package com.taejune.algorithm.leetcode;

import java.util.*;
import java.util.stream.Collectors;

//https://leetcode.com/problems/3sum/
public class Problem15 {
    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> answer = new ArrayList<>();

            if (nums.length < 3) {
                return answer;
            }
            if (nums.length > 2 && Arrays.stream(nums).allMatch(e -> e == 0)) {
                answer.add(Arrays.stream(new int[]{0, 0, 0}).boxed().collect(Collectors.toList()));
                return answer;
            }

            if (nums.length > 2 && Arrays.stream(nums).filter(e -> e == 0).count() >= 3) {
                answer.add(Arrays.stream(new int[]{0, 0, 0}).boxed().collect(Collectors.toList()));
            }

            Arrays.sort(nums);

//            System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));

            ArrayList<Integer> idxList = new ArrayList<>();
            idxList.add(0);
            int n = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > n) {
                    idxList.add(i);
                    n = nums[i];
                }
            }

            Map<Integer, Boolean> hasDups = new HashMap<>();
            for (int idx : idxList) {
                if ((idx + 1 < nums.length) && nums[idx] == nums[idx + 1]) {
                    hasDups.put(nums[idx], true);
                }
            }

//            System.out.println(idxList);
//            System.out.println(hasDups);

            for (int idxOfI = 0; idxOfI < idxList.size(); idxOfI++) {
                int i = nums[idxList.get(idxOfI)];
                for (int idxOfJ = (hasDups.getOrDefault(i, false)) ? idxOfI : idxOfI + 1; idxOfJ < idxList.size(); idxOfJ++) {
                    int j = nums[idxList.get(idxOfJ)];
                    for (int idxOfK = (hasDups.getOrDefault(j, false) && (idxOfI != idxOfJ)) ? idxOfJ : idxOfJ + 1; idxOfK < idxList.size(); idxOfK++) {
                        int k = nums[idxList.get(idxOfK)];
                        if (i + j + k == 0) {
                            int[] arr = new int[]{i, j, k};
                            answer.add(Arrays.stream(arr).boxed().sorted().collect(Collectors.toList()));
                        }
                    }
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        System.out.println("case01: ");
        List<List<Integer>> case01 = new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        for (List l : case01) {
            System.out.println(l);
        }
        // expect [[-1,-1,2],[-1,0,1]]

        System.out.println("case02: ");
        List<List<Integer>> case02 = new Solution().threeSum(new int[]{});
        for (List l : case02) {
            System.out.println(l);
        }
        // expect []

        System.out.println("case03: ");
        List<List<Integer>> case03 = new Solution().threeSum(new int[]{0});
        for (List l : case03) {
            System.out.println(l);
        }
        // expect []

        System.out.println("case04: ");
        List<List<Integer>> case04 = new Solution().threeSum(new int[]{0, 0, 0});
        for (List l : case04) {
            System.out.println(l);
        }
        // expect [0, 0, 0]

        System.out.println("case05: ");
        List<List<Integer>> case05 = new Solution().threeSum(new int[]{0, 0});
        for (List l : case05) {
            System.out.println(l);
        }
        // expect []

        System.out.println("case06: ");
        List<List<Integer>> case06 = new Solution().threeSum(new int[]{1, 1, -2});
        for (List l : case06) {
            System.out.println(l);
        }
        // expect [[-2,1,1]]

        System.out.println("case07: ");
        List<List<Integer>> case07 = new Solution().threeSum(new int[]{-1, 0, 1, 0});
        for (List l : case07) {
            System.out.println(l);
        }
        // expect [[-1,0,1]]

        System.out.println("case08: ");
        List<List<Integer>> case08 = new Solution().threeSum(new int[]{-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0});
        for (List l : case08) {
            System.out.println(l);
        }
        // expect [[-5,1,4],[-4,0,4],[-4,1,3],[-2,-2,4],[-2,1,1],[0,0,0]]

        System.out.println("case09: ");
        List<List<Integer>> case09 = new Solution().threeSum(new int[]{4, 4, 3, -5, 0, 0, 0, -2, 3, -5, -5, 0});
        for (List l : case09) {
            System.out.println(l);
        }
        // expect [[0,0,0]]

        System.out.println("case10: ");
        List<List<Integer>> case10 = new Solution().threeSum(new int[]{-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0});
        for (List l : case10) {
            System.out.println(l);
        }
        // expect [[-5,1,4],[-4,0,4],[-4,1,3],[-2,-2,4],[-2,1,1],[0,0,0]]
    }
}
