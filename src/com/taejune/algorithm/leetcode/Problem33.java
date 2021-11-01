package com.taejune.algorithm.leetcode;

public class Problem33 {
    static class Solution {
        public int search(int[] nums, int target) {
            return searchByHalf(nums, 0, nums.length - 1, target);
        }

        int searchByHalf(int[] arr, int from, int to, int target) {
            int pivot = (from + to) / 2;
            if (pivot == from && pivot + 1 <= to) {
                pivot = pivot + 1;
            }
            System.out.printf("from: %d(%d)/ to: %d(%d) ==> pivot: %d(%d)\n", from, arr[from], to, arr[to], pivot, arr[pivot]);
            if (target == arr[pivot]) {
                return pivot;
            }
            if (arr[pivot] > arr[from]) { // 중간 인덱스까지 증가할 때
                if (target > arr[pivot] || target < arr[from]) {
                    return searchByHalf(arr, pivot, to, target);
                } else {
                    return searchByHalf(arr, from, pivot, target);
                }
            } else if (arr[pivot] < arr[from]) { // 중간 인덱스 이전에 rotate가 되었을 때
                if (target < arr[pivot] || target > arr[from]) {
                    return searchByHalf(arr, from, pivot, target);
                } else {
                    return searchByHalf(arr, pivot, to, target);
                }
            }

            return -1;
        }
    }

    public static void main(String[] args) {
        int case01 = new Solution().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
        assert case01 == 4;
        System.out.println(case01);

        int case02 = new Solution().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3);
        assert case02 == -1;
        System.out.println(case02);

        int case03 = new Solution().search(new int[]{1}, 0);
        assert case03 == -1;
        System.out.println(case03);

        int case04 = new Solution().search(new int[]{1, 3}, 3);
        assert case04 == 1;
        System.out.println(case04);
    }
}
