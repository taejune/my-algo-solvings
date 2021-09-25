package com.taejune.algorithm.programmers.dfs;

// https://programmers.co.kr/learn/courses/30/lessons/43163

import java.util.*;
import java.util.stream.Collectors;

public class Problem03 {

    static class Solution {
        public int solution(String begin, String target, String[] words) {
            Set<String> s = Arrays.stream(words).collect(Collectors.toSet());
            if (!s.contains(target)) {
                return 0;
            }
            s.remove(target);
            s.add(begin);

            TreeNode root = new TreeNode(target);
            root = build(root, target, s);

            return traverse(root, 0, 51, begin);
        }

        class TreeNode {
            private List<TreeNode> adjacents;
            private String v;

            public TreeNode(String s) {
                adjacents = new ArrayList<>();
                v = s;
            }

            public TreeNode attach(TreeNode n) {
                adjacents.add(n);
                return this;
            }

            public String toString() {
                return v;
            }

            public List<TreeNode> getAdjacents() {
                return adjacents;
            }
        }

        private TreeNode build(TreeNode root, String target, Set<String> candidates) {
            List<String> electeds = new ArrayList<>();
            for (String candidate : candidates) {
                int nDifferChars = 0;
                for (int i = 0; i < target.length(); i++) {
                    if (target.charAt(i) != candidate.charAt(i)) {
                        nDifferChars++;
                    }
                }
                if (nDifferChars == 1) {
                    electeds.add(candidate);
                }
            }

            for (String e : electeds) {
                TreeNode node = new TreeNode(e);
                Set<String> copy = new HashSet<>();
                copy.addAll(candidates);
                copy.remove(e);
                node = build(node, e, copy);
                root.attach(node);
            }

            return root;
        }

        private int traverse(TreeNode root, int cur, int min, String target) {
            System.out.println("[cur:" + cur + "/ min: " + min + "]: " + root);

            if (target.compareTo(root.toString()) == 0 && cur <= min) {
                System.out.println("FOUND!!!");
                return cur;
            }

            for (TreeNode adj : root.getAdjacents()) {
                int m = traverse(adj, cur + 1, min, target);
                if (m <= min) {
                    min = m;
                }
            }

            return min;
        }
    }

    public static void main(String[] args) {
        int case01 = new Solution().solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        assert case01 == 4;
        System.out.println(case01);

        int case02 = new Solution().solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"});
        assert case02 == 0;
        System.out.println(case02);
    }
}
