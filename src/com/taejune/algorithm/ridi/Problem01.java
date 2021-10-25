package com.taejune.algorithm.ridi;

/*
개미수열은 다음과 같은 수열입니다. (이 수열은 소설 "개미"에서 소개되었기 때문에 개미 수열이라고 불립니다.)

1, 11, 12, 1121, 122111 .....
이 수열은 앞의 수의 연속된 같은 숫자를 묶어서 숫자와 그 개수를 읽는 방식으로 만들어집니다.

1을 "1이 한 개" 혹은 11로 읽습니다.
11을 "1이 두 개" 혹은 12로 읽습니다.
12를 "1이 한 개, 2가 한 개" 혹은 1121로 읽습니다.
1121을 "1이 두 개, 2가 한 개, 1이 한 개" 혹은 122111로 읽습니다.
이와 같은 방법으로 계속해서 다음 수를 만들어 갑니다.
입력으로 n 이 주어질 때 n번째 개미 수열을 문자열 형태로 return 하도록 solution 함수를 완성해주세요.

제한사항
n은 40이하의 자연수입니다.
 */

public class Problem01 {
    static class Solution {
        public String solution(int n) {
            int num;
            String result = "1";
            String str = "";
            int[] cnt = new int[9];

            for (int i = 0; i < n; i++) {
                str = result;
                result = "";

                for (int j = 0; j < str.length(); j++) {
                    num = str.charAt(i) - '0';
                    cnt[num - 1]++;
                    if ((j == str.length() - 1) || (str.charAt(i) != str.charAt(i + 1))) {
                        str += num + "" + cnt[num - 1];
                        cnt[num - 1] = 0;
                    }
                }
            }
            return result;
        }
    }

    static class Solution2 {
        public String solution(int n) {
            String result = ant(n);
            return result;
        }

        public String ant(int n) {
            String result = "1";
            if (n == 1) return result;

            String past = ant(n - 1);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < past.length(); i++) {
                int cnt = 1;
                while (i < past.length() - 1 && past.charAt(i) == past.charAt(i + 1)) {
                    cnt++;
                    i++;
                }
                sb.append("" + past.charAt(i) + cnt);
            }
            result = sb.toString();
            return result;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(2));
        System.out.println(s.solution(5));
    }
}
