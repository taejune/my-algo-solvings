package com.taejune.algorithm.programmers.hash;

import java.util.HashMap;

// https://programmers.co.kr/learn/courses/30/lessons/42576
public class Problem01 {

    public static void main(String[] args) {
        Solution3 s = new Solution3();

        String[] participant01 = new String[]{"leo", "kiki", "eden"};
        String[] completion01 = new String[]{"eden", "kiki"};
        String solve01 = s.solution(participant01, completion01);

        System.out.println("CASE01: " + solve01);
        assert solve01== "leo";

        String[] participant02 = new String[]{"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion02 = new String[]{"josipa", "filipa", "marina", "nikola"};
        String solve02 = s.solution(participant02, completion02);

        System.out.println("CASE02: " + solve02);
        assert solve02.equals("vinko");

        String[] participant03 = new String[]{"mislav", "stanko", "mislav", "ana"};
        String[] completion03 = new String[]{"stanko", "ana", "mislav"};
        String solve03 = s.solution(participant03, completion03);

        System.out.println("CASE03: " + solve03);
        assert solve03  == "mislav";
    }

    static class Solution {
        public String solution(String[] participant, String[] completion) {
            String answer = "";

            NameMap nm = new NameMap();
            for(String p : completion) {
                nm.add(p);
            }

            for(String p : participant) {
                if(!nm.exist(p)) {
                    return p;
                }
            }

            return answer;
        }

        public static class NameMap {
            private int[][] m;

            public NameMap() {
                m = new int[23][20];
                for(int i=0; i<20; i++) {
                    for(int j=0; j<23; j++) {
                        m[j][i] = 0;
                    }
                }
            }

            public NameMap add(String name) {
                int idx = 0;
                StringBuilder sb = new StringBuilder(name);
                for(int i=0; i<sb.length(); i++) {
                    int letterIdx = Character.getNumericValue(sb.charAt(i)) - 10;
                    m[letterIdx][idx++]++;
                }
                return this;
            }

            public boolean exist(String name) {
                int idx = 0;
                StringBuilder sb = new StringBuilder(name);
                for(int i=0; i<sb.length(); i++) {
                    int letterIdx = Character.getNumericValue(sb.charAt(i)) - 10;
                    if(m[letterIdx][idx++]-- == 0) {
                        return false;
                    }
                }
                return true;
            }
        }
    }

    static class Solution2 {
        public String solution(String[] participant, String[] completion) {
            String answer = "";

            HashMap map = new HashMap<String, Integer>();

            for (String s : participant) {
                if (map.containsKey(s)) {
                    map.put(s,  (Integer) map.get(s) + 1);
                } else {
                    map.put(s, 1);
                }
            }

            for (String s : completion) {
                map.put(s, (Integer) map.get(s) - 1);
            }

            for (String s : participant) {
                if ((Integer) map.get(s) != 0) {
                    answer = s;
                    break;
                }
            }

            return answer;
        }
    }

    static class Solution3 {
        public String solution(String[] participant, String[] completion) {
            String answer = "";

            HashMap map = new HashMap<String, Integer>();

            for (String s : completion) {
                if (map.containsKey(s)) {
                    map.put(s,  (Integer) map.get(s) + 1);
                } else {
                    map.put(s, 1);
                }
            }

            for (String s : participant) {
                try {
                    if ((Integer) map.get(s) == 0) {
                        answer = s;
                        break;
                    }
                    map.put(s,  (Integer) map.get(s) - 1);
                } catch (Exception e) {
                    answer = s;
                    break;
                }
            }

            return answer;
        }
    }
}
