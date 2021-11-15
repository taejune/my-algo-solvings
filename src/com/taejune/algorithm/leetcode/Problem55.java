package com.taejune.algorithm.leetcode;

// https://leetcode.com/problems/jump-game/
public class Problem55 {
    static class Solution {
        public boolean canJump(int[] nums) {
            if (nums.length == 1) {
                return true;
            }

            int lastReachableIndex = nums.length - 1;
            for (int i = lastReachableIndex - 1; i >= 0; i--) {
                int dist = lastReachableIndex - i;
                if (nums[i] >= dist) {
                    lastReachableIndex = i;
                }
            }

            if (lastReachableIndex == 0) {
                return true;
            }

            return false;
        }
    }

    public static void main(String[] args) {
        boolean case01 = new Solution().canJump(new int[]{2, 3, 1, 1, 4});
        assert case01;
        System.out.println(case01);

        boolean case02 = new Solution().canJump(new int[]{3, 2, 1, 0, 4});
        assert case02 == false;
        System.out.println(case02);

        boolean case03 = new Solution().canJump(new int[]{3, 2, 2, 0, 4});
        assert case03;
        System.out.println(case03);

        boolean case04 = new Solution().canJump(new int[]{2});
        assert case04;
        System.out.println(case04);

        boolean case05 = new Solution().canJump(new int[]{0});
        assert case05;
        System.out.println(case05);

        boolean case06 = new Solution().canJump(new int[]{2, 0, 0});
        assert case06;
        System.out.println(case06);

    }
}
