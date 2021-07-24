package com.taejune.algorithm.programmers.heap;

import java.util.PriorityQueue;

// https://programmers.co.kr/learn/courses/30/lessons/42626
public class Problem01 {

    static class Solution {
        public int solution(int[] scoville, int K) {
            int answer = 0;
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for(int s : scoville) {
                queue.add(s);
            }

            while(queue.peek() < K) {
                if(queue.size() == 1) {
                    return -1;
                }
                int most = queue.poll();
                int second = queue.poll();
                int stir = most + (second * 2);

                queue.add(stir);
                answer++;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

    }
}
