package com.taejune.algorithm.programmers.greedy;

import java.util.*;

public class Problem01 {

    static class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            System.out.println("Start ------");
            List<Integer> rest = new ArrayList<>();
            for (int r : reserve) {
                rest.add(r);
            }

            Map<Integer, Boolean> notAfford = new HashMap<>();
            for (int l : lost) {
                notAfford.put(l, true);
            }

            // 1. 여벌을 가져온 사람이 도난 경우
            for (int i = 0; i < rest.size(); i++) {
                if (notAfford.getOrDefault(rest.get(i), false)) {
                    notAfford.remove(rest.get(i));
                    rest.remove(i);
                }
            }

            // 2. 여벌을 가져왔는데 한 쪽만 안 가져온 경우
            boolean doesReArranged;
            do {
                doesReArranged = false;
                for (int i = 0; i < rest.size(); i++) {
                    int r = rest.get(i);
                    if ((notAfford.getOrDefault(r - 1, false) && !notAfford.getOrDefault(r + 1, false))) {
                        System.out.println("only before " + r + " is not afforable");
                        notAfford.remove(r - 1);
                        rest.remove(i);
                        doesReArranged = true;
                    } else if (!notAfford.getOrDefault(r - 1, false) && notAfford.getOrDefault(r + 1, false)) {
                        System.out.println("only after " + r + " is not afforable");
                        notAfford.remove(r + 1);
                        rest.remove(i);
                        doesReArranged = true;
                    } else {
                        System.out.println("both " + r + " is not afforable");
                    }
                }
            } while (doesReArranged);

            for (int i = 0; i < rest.size(); i++) {
                int r = rest.get(i);
                if (notAfford.getOrDefault(r - 1, false)) {
                    notAfford.remove(r - 1);
                    rest.remove(i);
                } else if (notAfford.getOrDefault(r + 1, false)) {
                    notAfford.remove(r + 1);
                    rest.remove(i);
                }
            }

            System.out.println("rest: " + rest.toString());
            System.out.println("not afforables: " + notAfford.toString());
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
        assert case06 == 2;
    }
}
