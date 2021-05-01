package com.taejune.algorithm.programmers.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// https://programmers.co.kr/learn/courses/30/lessons/42746
public class Problem02 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        String case01 = solution.solution(new int[]{1, 2, 3});
        assert case01.equals("12");
        System.out.println(case01);

        String case02 = solution.solution(new int[]{6, 10, 2});
        assert case02.equals("6210");
        System.out.println(case02);

        String case03 = solution.solution(new int[]{3, 30, 34, 5, 9});
        assert case03.equals("9534330");
        System.out.println(case03);
//        9, 90, 95, 7
//        9799590

    }

    static class Solution {
        public String solution(int[] numbers) {
            String answer = "";

            int max = 0 ;
            ArrayList<Integer> list = (ArrayList<Integer>) Arrays.stream(numbers).boxed().collect(Collectors.toList());
            for (List<Integer> comb : combinationList(list)) {
                int n = joinedNumber(comb.stream().mapToInt(i -> i).toArray());
                if(max < n) {
                    max = n;
                }
            }

            return String.valueOf(max);
        }

        private List<List<Integer>> combinationList(List<Integer> candinate) {
            List<List<Integer>> ret = new ArrayList<>();
            if (candinate.size() == 1) {
                ret.add(candinate);
            } else {
                for (int i = 0; i < candinate.size(); i++) {
                    List<Integer> copy = new ArrayList<>(candinate);
                    int removed = copy.remove(i);
                    List<List<Integer>> subcombinationList = combinationList(copy);
                    for (List<Integer> subcombination : subcombinationList) {
                        subcombination.add(0, removed);
                        ret.add(subcombination);
                    }
                }
            }
            return ret;
        }

        private int joinedNumber(int[] numbers) {
            StringBuilder sb = new StringBuilder();
            for (int n : numbers) {
                sb.append(n);
            }
            return Integer.parseInt(sb.toString());
        }
    }
}
