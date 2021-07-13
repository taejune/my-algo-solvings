package com.taejune.algorithm.programmers.stackqueue;

import java.util.ArrayList;

public class Problem01 {
    static class Solution {
        public int[] solution(int[] progresses, int[] speeds) {

            int nCompleted = 0;
            ArrayList<Integer> completed = new ArrayList<>();
            while(nCompleted < progresses.length) {
                for(int i=nCompleted; i<progresses.length; i++) {
                    progresses[i] += speeds[i];
                }

                boolean isFirstProcessComplete = false;
                for(int i=nCompleted; i<progresses.length; i++) {
                    if(isFirstProcessComplete){
                        if(isComplete(progresses, i)){
                            if(i == progresses.length - 1) {
                                completed.add(i - nCompleted + 1);
                                nCompleted = progresses.length;
                                break;
                            } else {
                                continue;
                            }
                        } else {
                            completed.add(i - nCompleted);
                            nCompleted = i;
                            break;
                        }
                    } else {
                        if(isComplete(progresses, nCompleted)) {
                            if(i == progresses.length - 1) {
                                completed.add(i - nCompleted + 1);
                                nCompleted = progresses.length;
                                break;
                            } else {
                                isFirstProcessComplete = true;
                                continue;
                            }

                        }
                    }
                }
            }

            int[] answer = new int[completed.size()];
            int idx = 0;
            for(int i : completed) {
                answer[idx++] = i;
            }

            return answer;
        }

        private boolean isComplete(int[] progresses, int idx) {
            return (progresses[idx] >= 100)? true : false;
        }

        private String toString(int[] progresses) {
            String s = "";
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
