package com.taejune.algorithm.programmers.hash;

import java.util.Arrays;

public class Problem02 {
    public static class TreeNode {
        boolean mark;
        TreeNode[] children;

        public TreeNode() {
            mark = false;
            children = new TreeNode[10];
        }

        public TreeNode add(int idx, TreeNode child) {
            children[idx] = child;
            return children[idx];
        }

        public TreeNode get(int idx) {
            return children[idx];
        }

        public boolean isMark() {
            return mark;
        }

        public TreeNode mark() {
            mark = true;
            return this;
        }
    }

    public static class Solution {
        public boolean solution(String[] phone_book) {
            boolean answer = true;
            Arrays.sort(phone_book, (a, b)->Integer.compare(a.length(), b.length()));
            TreeNode root = new TreeNode();
            for(String phone_number : phone_book) {
                TreeNode cur = root;
                StringBuilder sb = new StringBuilder(phone_number);
                for(int i=0; i<sb.length(); i++) {
                    int n = Character.getNumericValue(sb.charAt(i));
                    if(cur.get(n) == null) {
                        cur = cur.add(n, new TreeNode());
                        if(i == sb.length()-1) { cur.mark(); }
                    } else {
                        cur = cur.get(n);
                        if(cur.isMark()) { return false; }
                    }
                }
            }
            return answer;
        }
    }

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
}
