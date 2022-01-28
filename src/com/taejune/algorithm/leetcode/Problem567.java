package com.taejune.algorithm.leetcode;

// https://leetcode.com/problems/permutation-in-string/submissions/
public class Problem567 {
    static class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int[] letters = new int[26];
            for (int i = 0; i < s1.length(); i++) {
                letters[s1.charAt(i) - 'a']++;
            }

            for (int from = 0; from < s2.length(); from++) {
                if (isInclusion(s2, from, letters.clone(), s1.length())) {
                    return true;
                }
            }
            return false;
        }

        boolean isInclusion(String s, int start, int[] letters, int nLetters) {
            if (s.length() - start < nLetters) {
                return false;
            }

            for (int i = start; i < start + nLetters; i++) {
                if (--letters[s.charAt(i) - 'a'] < 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        boolean case01 = new Solution().checkInclusion("ab", "eidbaooo");
        assert case01;
        System.out.println(case01);

        boolean case02 = new Solution().checkInclusion("ab", "eidboaoo");
        assert !case02;
        System.out.println(case02);

        boolean case03 = new Solution().checkInclusion("hello", "ooolleoooleh");
        assert !case03;
        System.out.println(case03);

        boolean case04 = new Solution().checkInclusion("ab", "eidboaoo");
        assert !case04;
        System.out.println(case04);

        boolean case05 = new Solution().checkInclusion("adc", "dcda");
        assert case05;
        System.out.println(case05);

    }
}
