package com.taejune.algorithm.zigbang;

import java.util.PriorityQueue;
import java.util.Queue;

public class Problem04 {
    static class Solution {
        final static int MAX_STAIR = 100000;

        public int solution(int durability, int len, int[] stair) {
            int answer = 0;

            PriorityQueue<Integer> q = new PriorityQueue<>();
            for (int i = 0; i < len; i++) {
                q.add(stair[i]);
            }

            int minHeight = averageHeight(stair[0], stair[len - 1], durability);

            int cur = 0;
            for (int i = 0; i < durability; i++) {
                int available = nearlestUpperHeight(q, cur, minHeight);
                answer = Math.max(answer, available - cur - 1);
                cur = available;
            }

            return answer;
        }

        private int averageHeight(int from, int to, int div) {
            return (int) Math.ceil((double) (to - from) / div);
        }

        private int nearlestUpperHeight(PriorityQueue<Integer> q, int from, int dist) {
            int nearlest = 0;
            boolean found = true;
            while (!found) {
                nearlest = q.peek();
                System.out.println("nearlest: " + nearlest);
                if (nearlest >= from + dist) {
                    found = false;
                }
            }
            return nearlest;
        }

    }

    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String input = br.readLine();
//        StringTokenizer st = new StringTokenizer(input, " ");
//        int K = Integer.parseInt(st.nextToken());
//        int N = Integer.parseInt(st.nextToken());
//
//        int[] stair = new int[N];
//        input = br.readLine();
//        st = new StringTokenizer(input, " ");
//        for(int i=0; i<N; i++) {
//            stair[i] = Integer.parseInt(st.nextToken());
//        }
//
//        System.out.println(new Solution().solution(K, N, stair));

        int case01 = new Solution().solution(2, 5, new int[]{1, 3, 5, 7, 9});
        System.out.println("solve: " + case01);
        assert case01 == 4;

        int case02 = new Solution().solution(2, 5, new int[]{1, 3, 5, 7, 12});
        System.out.println("solve: " + case02);
        assert case01 == 6;

        int case03 = new Solution().solution(2, 4, new int[]{1, 10, 31, 50});
        System.out.println("solve: " + case03);
        assert case03 == 30;

        int case04 = new Solution().solution(2, 6, new int[]{1, 5, 10, 17, 20, 50});
        System.out.println("solve: " + case04);
        assert case04 == 30;
    }
}
