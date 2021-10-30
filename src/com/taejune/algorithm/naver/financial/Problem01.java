package com.taejune.algorithm.naver.financial;

import java.util.HashMap;
import java.util.Map;

public class Problem01 {
    static class Solution {
        public int solution(String[] id_list, int k) {
            int answer = 0;

            Map<String, Integer> couponsPerUser = new HashMap<>();

            for (int i = 0; i < id_list.length; i++) {
                Map<String, Boolean> got = new HashMap<>();

                String[] users = id_list[i].split(" ");
                for(String u : users) {
                    int nCoupon = couponsPerUser.getOrDefault(u, 0);
                    if(!got.getOrDefault(u, false) && nCoupon < k) {
                        got.put(u, true);
                        nCoupon++;
                    }
                    couponsPerUser.put(u, nCoupon);
                }
            }

            for(int coupon : couponsPerUser.values()) {
                answer += coupon;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        int case01 = new Solution().solution(new String[]{"A B C D", "A D", "A B D", "B D"}, 2);
        assert case01 == 7;
        System.out.println(case01);

        int case02 = new Solution().solution(new String[]{"JAY", "JAY ELLE JAY MAY", "MAY ELLE MAY", "ELLE MAY", "ELLE ELLE ELLE", "MAY"}, 3);
        assert case02 == 8;
        System.out.println(case02);
    }
}
