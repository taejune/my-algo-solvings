package com.taejune.algorithm.leetcode;

import java.util.*;

public class Problem17 {
    public static class PhoneNumber {
        Map<Integer, List<Character>> map;

        public PhoneNumber() {
            map = new HashMap<>();
            int keyNum = 2;
            for (int i = 0; i < 26; i++) {
                if (i == 3) { // 2
                    keyNum++;
                }
                if (i == 6) { // 3
                    keyNum++;
                }
                if (i == 9) { // 4
                    keyNum++;
                }
                if (i == 12) { // 5
                    keyNum++;
                }
                if (i == 15) { // 6
                    keyNum++;
                }
                if (i == 19) { // 7
                    keyNum++;
                }
                if (i == 22) { // 8
                    keyNum++;
                }
                List<Character> l = map.getOrDefault(keyNum, new ArrayList<>());
                l.add((char) ((int) 'a' + i));
                map.put(keyNum, l);
            }

        }

        private List<Character> get(char num) {
            return map.get(num - '1' + 1);
        }
    }

    static class Solution {
        public List<String> letterCombinations(String digits) {
            List<String> answer = new ArrayList<>();
            PhoneNumber p = new PhoneNumber();

            List<List<Character>> letters = new ArrayList<>();
            for (int i = 0; i < digits.length(); i++) {
                List<Character> l = p.get(digits.charAt(i));
                letters.add(l);
            }

            answer = combination(answer, letters);
            return answer;
        }

        private List<String> combination(List<String> output, List<List<Character>> input) {
            if(input.isEmpty()) {
                return output;
            }
            List<Character> chars = input.remove(0);
            List<String> res = new ArrayList<>();
            if(output.isEmpty()) {
                for (Character c : chars) {
                    res.add(c.toString());
                }
            } else {
                for (String s : output) {
                    for (Character c : chars) {
                        StringBuilder sb = new StringBuilder(s);
                        sb.append(c);
                        res.add(sb.toString());
                    }
                }
            }
            return combination(res, input);
        }
    }

    public static void main(String[] args) {

        System.out.println("case01");
        List<String> case01 = new Solution().letterCombinations("23");
        System.out.println(case01);
        // expect ["ad","ae","af","bd","be","bf","cd","ce","cf"]

        System.out.println("case02");
        List<String> case02 = new Solution().letterCombinations("");
        System.out.println(case02);
        // expect []

        System.out.println("case03");
        List<String> case03 = new Solution().letterCombinations("2");
        System.out.println(case03);
        // expect ["a","b","c"]
    }
}
