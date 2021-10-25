package com.taejune.algorithm.zigbang;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem01 {

    static class Solution {
        public String solution(int len, int pivot, String input) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < len; i++) {
                sb.append(shiftChar(input.charAt(i), (int) Math.pow(pivot, i+1)));
            }
            return sb.toString();
        }

        private char shiftChar(char from, int shift) {
            return (char) (((from - 'a' + shift) % 26) + 'a');
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input, " ");
        String word = br.readLine();
        System.out.println(new Solution().solution(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), word));
//        String case01 = new Solution().solution(5, 1, "cloud");
//        System.out.println("solve: " + case01);
//        assert case01.equals("dmpve");
//
//        String case02 = new Solution().solution(5, 3, "cloud");
//        System.out.println("solve: " + case02);
//        assert case02.equals("fupxm");

    }
}
