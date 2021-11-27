package com.taejune.algorithm.leetcode;

import java.util.PriorityQueue;

public class Problem04 {
    static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {

            int total = nums1.length + nums2.length;
            int cur = 0, idx1 = 0, idx2 = 0;
            int medianIdx = total / 2;
            double median = 0;

            do {

                if (nums1[idx1] <= nums2[idx2]) {
                    idx1++;
                } else {
                    idx2++;
                }

            } while (cur++ < medianIdx);


            return median;
        }
    }

    public static void main(String[] args) {

        double case01 = new Solution().findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        assert case01 == 2.0;
        System.out.println(case01);

        double case02 = new Solution().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        assert case02 == 2.5;
        System.out.println(case02);

        double case03 = new Solution().findMedianSortedArrays(new int[]{0, 0}, new int[]{0, 0});
        assert case03 == 0.0;
        System.out.println(case03);

        double case04 = new Solution().findMedianSortedArrays(new int[]{}, new int[]{1});
        assert case04 == 1.0;
        System.out.println(case04);

        double case05 = new Solution().findMedianSortedArrays(new int[]{2}, new int[]{});
        assert case05 == 2.0;
        System.out.println(case05);

    }
}
