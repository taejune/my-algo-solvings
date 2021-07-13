package com.taejune.algorithm.programmers.stackqueue;

import java.util.ArrayList;

public class Problem01 {
    static class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            int[] answer = {};

            int nCompleted = 0;
            ArrayList<Integer> completed = new ArrayList<>();

            int cnt = 0;
            while(nCompleted < progresses.length) {
                System.out.println(nCompleted + " " + progresses.length);
                System.out.println(cnt++ + ": " + print(progresses));

                for(int i=nCompleted; i<progresses.length; i++) {
                    progresses[i] += speeds[i];
                }

                boolean completeExist = false;

                for(int i=nCompleted; i<=progresses.length; i++) {
                    if(i==progresses.length) {
                        completed.add(progresses.length - nCompleted);
                        nCompleted = progresses.length;
                        break;
                    }
                    if(isComplete(progresses, i)) {
                        completeExist = true;
                        continue;
                    } else if(completeExist){
                        nCompleted = i;
                        completed.add(nCompleted);
                        break;
                    }
                }

            }

            System.out.println("end");
            return answer;
        }

        private boolean isComplete(int[] progresses, int idx) {
            return (progresses[idx] >= 100)? true : false;
        }

        private String print(int[] progresses) {
            String s = null;
            for(int i=0; i<progresses.length; i++) {
                s = s + progresses[i] + ", ";
            }
            return s;
        }
    }

    static Solution s = new Solution();

    public static void main(String[] args) {
        int[] progress1 = new int[]{93, 30, 55};
        int[] speeds1 = new int[]{1, 30, 5};
        int[] answer1 = s.solution(progress1, speeds1);
        for(int i=0; i<answer1.length; i++) {
            System.out.println(answer1[i]);
        }
        // [2, 1]

        int[] progress2 = new int[]{95, 90, 99, 99, 80, 99};
        int[] speeds2 = new int[]{1, 1, 1, 1, 1, 1};
        int[] answer2 = s.solution(progress2, speeds2);
        for(int i=0; i<answer2.length; i++) {
            System.out.println(answer2[i]);
        }
        // [1, 3, 2]
    }
}
