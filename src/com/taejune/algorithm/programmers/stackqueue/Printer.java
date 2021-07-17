package com.taejune.algorithm.programmers.stackqueue;

public class Printer {
    static class Solution {
        static int counter = 1;

        public int solution(int[] priorities, int location) {
            if (!shouldArrage(priorities)) {
                if (location == 0) {
                    return counter;
                }
                counter++;
                priorities = eject(priorities);
                switch (location) {
                    case 0:
                        location = priorities.length - 1;
                        break;
                    default:
                        location = location - 1;
                }
                return solution(priorities, location);
            }

            priorities = arrange(priorities);
            switch (location) {
                case 0:
                    location = priorities.length - 1;
                    break;
                default:
                    location = location - 1;
            }

            System.out.printf("printed %s | %d | %s\n", counter, location, toString(priorities));
            return solution(priorities, location);
        }

        //
        private boolean shouldArrage(int[] priorities) {
            int first = priorities[0];
            for (int i = 1; i < priorities.length; i++) {
                if (priorities[i] > first) {
                    return true;
                }
            }
            return false;
        }

        // move first element to last.
        private int[] arrange(int[] priorities) {
            int[] arranged = new int[priorities.length];
            for (int i = 1; i < priorities.length; i++) {
                arranged[i - 1] = priorities[i];
            }
            arranged[arranged.length - 1] = priorities[0];
            return arranged;
        }

        // remove first element.
        private int[] eject(int[] priorities) {
            int[] printed = new int[priorities.length - 1];
            for (int i = 1; i < priorities.length; i++) {
                printed[i - 1] = priorities[i];
            }
            return printed;
        }

        private String toString(int[] priorities) {
            String arr = "";
            for (int i = 0; i < priorities.length; i++) {
                arr += "'" + priorities[i] + "',";
            }
            return "{" + arr + "}";
        }
    }

    public static void main(String[] args) {

        Solution s = new Solution();
        int[] priorities01 = new int[]{2, 1, 3, 2};
        int location01 = 2;
        int answer01 = s.solution(priorities01, location01);

        System.out.println("first answer: " + answer01);
        assert 1 == answer01;

        int[] priorities02 = new int[]{1, 1, 9, 1, 1, 1};
        int location02 = 0;
        int answer02 = s.solution(priorities02, location02);
        System.out.println("second answer: " + answer02);
        assert 1 == s.solution(priorities02, location02);

    }
}
