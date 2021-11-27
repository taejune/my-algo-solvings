package com.taejune.algorithm.linepay211127;

import java.util.ArrayList;
import java.util.List;

public class Problem02 {
    static class Solution {
        public int solution(int[] arr) {
            int answer = 0;

            // 변곡점
            List<List<Integer>> inflectionIdxLists = new ArrayList<>();
            List<Integer> inflectionIdx = new ArrayList<>();

            // 처음부터 작아지거나 같은 숫자가 반복될 경우 스킵
            int prev = arr[0];
            int startIdx = 0;
            for (int i = 1; i < arr.length; i++) {
                if (prev < arr[i]) {
                    startIdx = i - 1;
                    break;
                }
                prev = arr[i];
            }

            boolean valid = true;
            boolean rising = true;
            inflectionIdx = new ArrayList<>();
            inflectionIdx.add(startIdx);
            for (int i = startIdx + 1; i < arr.length; i++) {
                if (valid) {
                    if (rising) {
                        if (prev < arr[i]) {
                            prev = arr[i];
                            continue;
                        } else if (prev == arr[i]) {
                            valid = false;
                        } else {
                            inflectionIdx.add(i - 1);
                            rising = false;
                            if (i == arr.length - 1) {
                                inflectionIdx.add(i);
                                inflectionIdxLists.add(inflectionIdx);
                            }
                        }
                    } else {
                        if (prev > arr[i]) {
                            prev = arr[i];
                            if (i == arr.length - 1) {
                                inflectionIdx.add(i);
                                inflectionIdxLists.add(inflectionIdx);
                            }
                            continue;
                        } else if (prev == arr[i]) {
                            inflectionIdx.add(i - 1);
                            inflectionIdxLists.add(inflectionIdx);
                            valid = false;
                        } else {
                            inflectionIdx.add(i - 1);
                            inflectionIdxLists.add(inflectionIdx);
                            inflectionIdx = new ArrayList<>();
                            inflectionIdx.add(i - 1);
                            rising = true;
                        }
                    }
                    prev = arr[i];
                } else {
                    if (prev < arr[i]) {
                        rising = true;
                        valid = true;
                        inflectionIdx = new ArrayList<>();
                        inflectionIdx.add(i - 1);
                    }
                }

            }

            for (List<Integer> curve : inflectionIdxLists) {
                int front = curve.get(1) - curve.get(0);
                int back = curve.get(2) - curve.get(1);
                answer += front * back;
            }

            return answer;
        }
    }

    public static void main(String[] args) {

        int case01 = new Solution().solution(new int[]{0, 1, 2, 5, 3, 7});
        int case02 = new Solution().solution(new int[]{1, 2, 3, 2, 1});
        int case03 = new Solution().solution(new int[]{1, 2, 3, 2, 1, 4, 3, 2, 2, 1});
        int case04 = new Solution().solution(new int[]{1, 2, 1, 2, 1});
    }
}
