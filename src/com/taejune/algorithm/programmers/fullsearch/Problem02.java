package com.taejune.algorithm.programmers.fullsearch;

import java.util.ArrayList;
import java.util.List;

public class Problem02 {

    public static class Solution {

        int upperBound = 10000000;
        boolean[] hasCount = new boolean[upperBound];

        public int solution(String numbers) {
            int answer = 0;

            boolean[] primes = makePrimes();

            List<Integer> nums = new ArrayList<>();
            for (int i = 0; i < numbers.length(); i++) {
                nums.add(Integer.parseInt(String.valueOf(numbers.charAt(i))));
            }
            answer = getNum(0, primes, nums, "");
            return answer;
        }

        private int getNum(int count, boolean[] primes, List<Integer> numbers, String s) {

            for (int i = 0; i < numbers.size(); i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(s);

                List<Integer> copy = new ArrayList<>(numbers);
                sb.append(copy.remove(i));

                if (primes[Integer.parseInt(sb.toString())] && !hasCount[Integer.parseInt(sb.toString())]) {
                    System.out.println(Integer.parseInt(sb.toString()));
                    count++;
                    hasCount[Integer.parseInt(sb.toString())] = true;
                }
                count = getNum(count, primes, copy, sb.toString());
            }
            return count;
        }

        private boolean[] makePrimes() {

            boolean[] numbers = new boolean[upperBound];
            for (int i = 2; i < upperBound; i++) {
                numbers[i] = true;
            }

            for (int i = 2; i < upperBound / 2; i++) {
                int base = i;
                if (numbers[base] == false) {
                    continue;
                }
                for (int j = 2; base * j < upperBound; j++) {
                    numbers[base * j] = false;
                }
            }

            return numbers;
        }
    }

    public static void main(String[] args) {

        int case01 = new Solution().solution("17");
        System.out.println(case01);

        int case02 = new Solution().solution("011");
        System.out.println(case02);
    }
}
