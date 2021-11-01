package com.taejune.algorithm.leetcode;

import java.util.Arrays;

public class Problem34 {
    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            int matchIndex = binarySearch(nums, 0, nums.length - 1, target);
            if(matchIndex < 0) {
                return new int[]{-1, -1};
            }
            int startIdx = matchIndex;
            int endIdx = matchIndex;
            for (int i = startIdx; i >= 0; i--) {
                if (nums[i] == target) {
                    startIdx = i;
                }
            }
            for (int i = endIdx; i < nums.length; i++) {
                if (nums[i] == target) {
                    endIdx = i;
                }
            }

            return new int[]{startIdx, endIdx};
        }

        int binarySearch(int[] arr, int from, int to, int target) {
            if (from > to || from > arr.length - 1) {
                return -1;
            }

            int pivot = (from + to) / 2;

            if (arr[pivot] > target) {
                return binarySearch(arr, from, pivot - 1, target);
            } else if (arr[pivot] == target) {
                return pivot;
            } else {
                return binarySearch(arr, pivot + 1, to, target);
            }
        }
    }

    public static void main(String[] args) {

        int[] case01 = new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        // expect [3, 4]
        assert Arrays.compare(case01,new int[]{3, 4}) == 0;


        int[] case02 = new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
        // expect [-1, -1]
        assert Arrays.compare(case02, new int[]{-1, -1}) == 0;

        int[] case03 = new Solution().searchRange(new int[]{}, 0);
        // expect [-1, -1]
        assert Arrays.compare(case03, new int[]{-1, -1}) == 0;

    }
}
