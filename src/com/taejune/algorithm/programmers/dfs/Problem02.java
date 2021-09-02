package com.taejune.algorithm.programmers.dfs;

import java.util.HashMap;
import java.util.Map;

public class Problem02 {
    static class Solution {
        public int solution(int n, int[][] computers) {
            int answer = 0;

            Map<Integer, Boolean> left = new HashMap<>();
            for(int i=0; i<n; i++) {
                left.put(i, true);
            }

            Map<Integer, Boolean> visited = new HashMap<>();

            while(!left.isEmpty()) {
                answer++;
                for(int i=0; i<n; i++) {
                    if(left.getOrDefault(i, false)) {
                        visited = traverse(n, computers, i, visited);
                        break;
                    }
                }
                for(int v : visited.keySet()) {
                    left.remove(v);
                }
            }

            return answer;
        }

        private Map<Integer, Boolean> traverse(int n, int[][] computers, int cur, Map<Integer, Boolean> visited) {
            if (visited.containsKey(cur)) {
                return visited;
            }
            visited.put(cur, true);

            for (int i = 0; i < computers[cur].length; i++) {
                if (computers[cur][i] == 1 && !visited.containsKey(i)) {
                    visited = traverse(n, computers, i, visited);
                }
            }
            return visited;
        }
    }


    public static void main(String[] args) {

        System.out.println("====== CASE 01 =======");
        int case01 = new Solution().solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
        System.out.println(case01); // 2

        System.out.println("====== CASE 02 =======");
        int case02 = new Solution().solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}});
        System.out.println(case02); // 1

        System.out.println("====== CASE 03 =======");
        int case03 = new Solution().solution(5, new int[][]{{1, 0, 1, 0, 0}, {0, 1, 0, 1, 0}, {1, 0, 1, 0, 0}, {0, 1, 0, 1, 0}, {0, 0, 0, 0, 1}});
        System.out.println(case03); // 3

        System.out.println("====== CASE 04 =======");
        int case04 = new Solution().solution(5, new int[][]{{1, 1, 1, 1, 0}, {1, 1, 0, 0, 0}, {1, 0, 1, 0, 0}, {1, 0, 0, 1, 0}, {0, 0, 0, 0, 1}});
        System.out.println(case04); // 2
    }
}
