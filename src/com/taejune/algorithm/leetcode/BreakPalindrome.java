package com.taejune.algorithm.leetcode;

// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/639/week-4-september-22nd-september-28th/3985/

public class BreakPalindrome {
    static class Solution {
        public String breakPalindrome(String palindrome) {
            String s = getLowerWords(palindrome);
            if (!isPalndrome(s)) {
                return s;
            }

            s = getUpperWords(palindrome);
            if (!isPalndrome(s)) {
                return s;
            }

            return "";
        }

        private boolean isPalndrome(String s) {
            int len = s.length();
            if (len > 1) {
                for (int i = 0; i < len / 2; i++) {
                    if (s.charAt(i) != s.charAt(len - i - 1)) {
                        return false;
                    }
                }
            }
            return true;
        }

        private String getLowerWords(String s) {
            StringBuilder sb = new StringBuilder(s);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != 'a') {
                    sb.setCharAt(i, 'a');
                    break;
                }
            }
            return sb.toString();
        }

        private String getUpperWords(String s) {
            StringBuilder sb = new StringBuilder(s);
            for (int i = s.length() - 1; i >= 0; i--) {
                if (sb.charAt(i) != 'z') {
                    sb.setCharAt(i, next(sb.charAt(i)));
                    break;
                }
            }
            return sb.toString();
        }

        private char next(char c) {
            return (char) (c + 1);
        }
    }

    public static void main(String[] args) {
        String case01 = new Solution().breakPalindrome("abccba");
        System.out.println(case01); // 'aaccba'

        String case02 = new Solution().breakPalindrome("a");
        System.out.println(case02); // emptry

        String case03 = new Solution().breakPalindrome("aa");
        System.out.println(case03); // 'ab'

        String case04 = new Solution().breakPalindrome("aba");
        System.out.println(case04); // 'abb'
    }
}
