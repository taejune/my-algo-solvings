package com.taejune.algorithm.programmers.hash;

import java.util.HashMap;

public class Problem03 {
    static class Solution {
        public int solution(String[][] clothes) {
            HashMap<String, Integer> map = new HashMap<>();
            for (String[] c : clothes) {
                map.put(c[1], map.getOrDefault(c[1], 0)+ 1);
            }

            System.out.println(map.toString());

            int answer = 1;
            for (String types : map.keySet()) {
                // 옷을 입지 않는 경우까지 더한 경우를 모두 곱
                answer *= (map.get(types) + 1);
            }
            // 아무 옷도 입지 않는 경우 제외
            answer--;

            return answer;
        }
    }

    public static void main(String[] args) {

        Solution s01 = new Solution();

        String[][] case01 = new String[][]{{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int answer01 = s01.solution(case01);
        System.out.println("first answer: " + answer01);
        assert answer01 == 5;

        Solution s02 = new Solution();

        String[][] case02 = new String[][]{{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
        int answer02 = s02.solution(case02);
        System.out.println("second answer: " + answer02);
        assert answer02 == 3;
    }
}
