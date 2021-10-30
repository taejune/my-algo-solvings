package com.taejune.algorithm.naver.financial;

import java.util.*;

public class Problem03 {
    static class Solution {
        public String[] solution(String[] logs) {
                     // 의심되는 수험자ID
            Set<String> suspects = new HashSet<>();

            Map<String, Integer> nSolvedPerStudent = new HashMap<>();
            Map<String, Set<Integer>> problemsIDPerStudent = new HashMap<>();
            Map<String, Map<Integer, Integer>> scorePerProblemsPerStudent = new HashMap<>();

            for (int i = 0; i < logs.length; i++) {
                String[] log = logs[i].split(" ");

                String studentID = log[0];
                int problemID = Integer.parseInt(log[1]);
                int score = Integer.parseInt(log[2]);

                int nSovled = nSolvedPerStudent.getOrDefault(studentID, 0);
                Set<Integer> sovledSet = problemsIDPerStudent.get(studentID);
                if(sovledSet != null && sovledSet.contains(problemID)) {
                    nSolvedPerStudent.put(studentID, nSovled);
                } else {
                    nSolvedPerStudent.put(studentID, ++nSovled);
                }

                Set<Integer> problemIDs = problemsIDPerStudent.getOrDefault(studentID, new HashSet<>());
                problemIDs.add(problemID);
                problemsIDPerStudent.put(studentID, problemIDs);

                Map<Integer, Integer> scorePerProblem = scorePerProblemsPerStudent.getOrDefault(studentID, new HashMap<>());
                scorePerProblem.put(problemID, score);
                scorePerProblemsPerStudent.put(studentID, scorePerProblem);
            }

            // 문제를 푼 수가 동일한 수험자 필터
            Map<Integer, Set<String>> sameSolved = new HashMap<>();
            for (Map.Entry<String, Integer> nProblemsStudent : nSolvedPerStudent.entrySet()) {
                int nSovled = nProblemsStudent.getValue();
                Set<String> s = sameSolved.getOrDefault(nSovled, new HashSet<>());
                s.add(nProblemsStudent.getKey());
                sameSolved.put(nSovled, s);
            }
            for (Set<String> s : sameSolved.values()) {
                if (s.size() > 1) {
                    for (String id : s) {
                        suspects.add(id);
                    }
                }
            }

            //
            Set<String> suspects2 = new HashSet<>();
            Map<String, Set<String>> problemsHashPerStudent = new HashMap<>();
            for (String id : suspects) {
                Set<Integer> sovledNumbers = problemsIDPerStudent.get(id);
                StringBuilder hash = new StringBuilder();
                for (int problemId : sovledNumbers) {
                    hash.append(problemId + ",");
                }
                Set ids = problemsHashPerStudent.getOrDefault(hash.toString(), new HashSet<>());
                ids.add(id);
                problemsHashPerStudent.put(hash.toString(), ids);
            }
            for (Set<String> students : problemsHashPerStudent.values()) {
                if (students.size() > 1) {
                    for (String s : students) {
                        if (suspects.contains(s)) {
                            suspects2.add(s);
                        }
                    }
                }
            }

            //
            Set<String> suspects3 = new HashSet<>();
            Map<String, Set<String>> scoreHashPerStudent = new HashMap<>();
            for (String id : suspects) {
                Map<Integer, Integer> scores = scorePerProblemsPerStudent.get(id);
                StringBuilder sb = new StringBuilder();

                for (Map.Entry<Integer, Integer> e : scores.entrySet()) {
                    int problemId = e.getKey();
                    int score = e.getValue();
                    sb.append("(" + problemId + "," + score + ")");

                }
                Set ids = scoreHashPerStudent.getOrDefault(sb.toString(), new HashSet<>());
                ids.add(id);
                scoreHashPerStudent.put(sb.toString(), ids);
            }
//            System.out.println(scoreHashPerStudent);
            for (Set<String> students : problemsHashPerStudent.values()) {
                if (suspects.size() > 1) {
                    for (String s : students) {
                        if (suspects2.contains(s)) {
                            suspects3.add(s);
                        }
                    }
                }
            }

            if (suspects3.size() < 1) {
                return new String[]{"None"};
            }

            System.out.println(suspects3);
            return null;
        }
    }

    public static void main(String[] args) {
        String[] case01 = new Solution().solution(new String[]{"0001 3 95", "0001 5 90", "0001 5 100", "0002 3 95", "0001 7 80", "0001 8 80", "0001 10 90", "0002 10 90", "0002 7 80", "0002 8 80", "0002 5 100", "0003 99 90"});
        for (String s : case01) {
            System.out.println(s);
        }
        //expect ["0001", "0002"]

        String[] case02 = new Solution().solution(new String[]{"1901 1 100", "1901 2 100", "1901 4 100", "1901 7 100", "1901 8 100", "1902 2 100", "1902 1 100", "1902 7 100", "1902 4 100", "1902 8 100", "1903 8 100", "1903 7 100", "1903 4 100", "1903 2 100", "1903 1 100", "1101 1 95", "1101 2 100", "1101 4 100", "1101 7 100", "1101 9 100", "1102 1 95", "1102 2 100", "1102 4 100", "1102 7 100", "1102 9 100"});
        for (String s : case01) {
            System.out.println(s);
        }
        // expect ["1101", "1102", "1901", "1902", "1903"]

        String[] case03 = new Solution().solution(new String[]{"1901 10 50", "1909 10 50"});
        for (String s : case01) {
            System.out.println(s);
        }
        // expect ["None"]
    }
}
