package com.taejune.algorithm.programmers.greedy;

import java.util.*;

public class Problem01 {
    static class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            Map<Integer, Boolean> rest = new HashMap<>();
            for (int r : reserve) {
                rest.put(r, true);
            }

            Map<Integer, Boolean> notAfford = new HashMap<>();
            for (int l : lost) {
                notAfford.put(l, true);
            }

            // 1. 여벌을 가져온 사람이 도난 경우
            List<Integer> rearranged = new ArrayList<>();
            for (int key : rest.keySet()) {
                if (notAfford.getOrDefault(key, false)) {
                    rearranged.add(key);
                }
            }

            for(int key : rearranged) {
                notAfford.remove(key);
                rest.remove(key);
            }

//            System.out.println("==== REMOVE SELF LOST BY RESERVED =====");
//            System.out.println("rest: " + rest.keySet().toString());
//            System.out.println("not afforables: " + notAfford.keySet().toString());

            // 2. 여벌을 가져왔는데 한 쪽만 안 가져온 경우
            boolean doesReArranged;
            do {
                doesReArranged = false;
                List<Integer> rearrangedReserved = new ArrayList<>();
                List<Integer> filledNotAfford = new ArrayList<>();
                for (int key : rest.keySet()) {
                    if ((notAfford.getOrDefault(key - 1, false) && !notAfford.getOrDefault(key + 1, false))) {
//                        System.out.println("only before " + key + " is not afforable");
                        rearrangedReserved.add(key);
                        filledNotAfford.add(key - 1);
                        doesReArranged = true;
                    } else if (!notAfford.getOrDefault(key - 1, false) && notAfford.getOrDefault(key + 1, false)) {
//                        System.out.println("only after " + key + " is not afforable");
                        rearrangedReserved.add(key);
                        filledNotAfford.add(key + 1);
                        doesReArranged = true;
                    } else {
//                        System.out.println("both " + key + " is not afforable");
                    }
                }

                for (int r : rearrangedReserved) {
                    rest.remove(r);
                }
                for (int r : filledNotAfford) {
                    notAfford.remove(r);
                }

            } while (doesReArranged);

            List<Integer> rearrangedReserved = new ArrayList<>();
            List<Integer> filledNotAfford = new ArrayList<>();
            for (int key : rest.keySet()) {
                if (notAfford.getOrDefault(key - 1, false)) {
                    rearrangedReserved.add(key);
                    filledNotAfford.add(key - 1);
                } else if (notAfford.getOrDefault(key + 1, false)) {
                    rearrangedReserved.add(key);
                    filledNotAfford.add(key + 1);
                }
            }
            for (int r : rearrangedReserved) {
                rest.remove(r);
            }
            for (int r : filledNotAfford) {
                notAfford.remove(r);
            }

//            System.out.println("==== FINAL =====");
//            System.out.println("rest: " + rest.keySet().toString());
//            System.out.println("not afforables: " + notAfford.keySet().toString());
            return n - notAfford.size();
        }
    }

    public static void main(String[] args) {
        int case01 = new Solution().solution(5, new int[]{2, 4}, new int[]{1, 3, 5});
        System.out.println(case01);
        assert case01 == 5;

        int case02 = new Solution().solution(5, new int[]{2, 4}, new int[]{3});
        System.out.println(case02);
        assert case02 == 4;

        int case03 = new Solution().solution(3, new int[]{3}, new int[]{1});
        System.out.println(case03);
        assert case03 == 2;

        int case04 = new Solution().solution(9, new int[]{1, 2, 3, 4}, new int[]{1});
        System.out.println(case04);
        assert case04 == 6;

        int case05 = new Solution().solution(9, new int[]{1, 2, 3, 4}, new int[]{1, 2, 3});
        System.out.println(case05);
        assert case05 == 8;

        int case06 = new Solution().solution(9, new int[]{1, 2, 3, 4}, new int[]{1});
        System.out.println(case06);
        assert case06 == 6;
    }
}
