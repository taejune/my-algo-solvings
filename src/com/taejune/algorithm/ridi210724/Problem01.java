package com.taejune.algorithm.ridi210724;

/*
 [개미수열]
 1 -> 11 -> 12 -> 1121 -> 122111 -> 112213 -> ...

1이 한 개 => 11
1이 두 개 => 12
1이 한 개, 2가 한 개 -> 1121
...

에 대해 n 번째 개미수열을 구하라.
 */

public class Problem01 {
    public static class Solution {
        public String solution(int n) {

            String answer = "1";
            for (int i = 1; i < n; i++) {
                answer = nextAntArray(answer);
            }
            return answer;
        }

        private String nextAntArray(String s) {
            StringBuffer sb = new StringBuffer();
            int cnt = 1;
            int before = s.charAt(0) - '0';
            for (int i = 1; i < s.length(); i++) {
                int c = s.charAt(i) - '0';
                if (c == before) {
                    cnt++;
                } else {
                    sb = sb.append(before).append(cnt);
                    before = c;
                    cnt = 1;
                }
            }
            sb = sb.append(before).append(cnt);
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(2)); // 11
        System.out.println(new Solution().solution(3)); // 12
        System.out.println(new Solution().solution(4)); // 1121
        System.out.println(new Solution().solution(5)); // 122111
    }
}
