package com.taejune.algorithm.leetcode;

// https://leetcode.com/problems/longest-palindromic-substring/
public class Problem05 {
    static class Solution {
        public String longestPalindrome(String s) {
            int max = 0;
            String longest = "";

            for (int i = 0; i < s.length(); i++) {
                String p = longestPalindromic(s, i);
                if (p.length() > max) {
                    max = p.length();
                    longest = p;
                }
            }

            return longest;
        }

        private String longestPalindromic(String s, int pivot) {
            // if pivot is not pair
            int cnt = 0;
            for (int i = 1; i <= pivot; i++) {
                if ((pivot - i < 0) || ((pivot + i) > (s.length() - 1)) ||
                        (s.charAt(pivot - i) != s.charAt(pivot + i))) {
                    break;
                }
                cnt++;
            }

            // if pivot is pair (ABBA)
            int cntPair = 0;
            boolean isPair = false;
            if ((pivot + 1 <= s.length() - 1) && s.charAt(pivot) == s.charAt(pivot + 1)) {
                isPair = true;
                for (int i = 1; i <= pivot; i++) {
                    if ((pivot - i < 0) || ((pivot + 1 + i) > (s.length() - 1)) ||
                            (s.charAt(pivot - i) != s.charAt(pivot + 1 + i))) {
                        break;
                    }
                    cntPair++;
                }
            }

            StringBuilder sb = new StringBuilder();
            int from = pivot - cnt;
            int to = pivot + cnt;

            if (isPair) {
                int _from = pivot - cntPair;
                int _to = pivot + cntPair + 1;
                if ((_to - from) > (to - from)) {
                    from = _from;
                    to = _to;
                }
            }

//            System.out.printf("%s(%d), from: %c(%d)/ to: %c(%d)\n", s, pivot, s.charAt(from), from, s.charAt(to), to);
            for (int i = from; i <= to; i++) {
                sb.append(s.charAt(i));
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        String case01 = new Solution().longestPalindrome("babad");
        System.out.println(case01);
        assert case01.equals("bab");

        String case02 = new Solution().longestPalindrome("cbbd");
        System.out.println(case02);
        assert case02.equals("bb");

        String case03 = new Solution().longestPalindrome("a");
        System.out.println(case03);
        assert case03.equals("a");

        String case04 = new Solution().longestPalindrome("ac");
        System.out.println(case04);
        assert case04.equals("a");

        String case05 = new Solution().longestPalindrome("zbcbccba");
        System.out.println(case05);
        assert case05.equals("bccb");

        String case06 = new Solution().longestPalindrome("bb");
        System.out.println(case06);
        assert case06.equals("bb");

        String case07 = new Solution().longestPalindrome("ccc");
        System.out.println(case07);
        assert case07.equals("ccc");

        String case08 = new Solution().longestPalindrome("aaaa");
        System.out.println(case08);
        assert case08.equals("aaaa");
    }
}
