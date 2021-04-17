package com.taejune.algorithm.programmers.hash;

// https://programmers.co.kr/learn/courses/30/lessons/42577?language=java
public class Problem02 {
    public static void main(String[] args) {
        Solution s = new Solution();

        String[] case01 = new String[]{"119", "97674223", "1195524421"}; // false
        boolean solve01 = s.solution(case01);
        System.out.println("CASE01: " + solve01);
        assert solve01 == false;

        String[] case02 = new String[]{"123","456","789"}; // true
        boolean solve02 = s.solution(case02);
        System.out.println("CASE02: " + solve02);
        assert solve02 == true;

        String[] case03 = new String[]{"12","123","1235","567","88"}; // false
        boolean solve03 = s.solution(case03);
        System.out.println("CASE03: " + solve03);
        assert solve03 == false;
    }

    public static class Solution {
        public boolean solution(String[] phone_book) {
            boolean answer = true;
            return answer;
        }
    }
}
