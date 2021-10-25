package com.taejune.algorithm.ridi;

/*
문제 설명
택배를 이용해 총 n개의 옷을 배송하려고 합니다. 택배 회사에는 현재 옷 3개, 5개를 담을 수 있는 상자가 준비되어 있습니다.
상자의 크기에 상관없이 상자의 개수로 배송비를 받기 때문에, 상자의 개수를 최소한으로 줄이려고 합니다.
단, 상자를 보내기 위해서는 상자에 반드시 들어갈 수 있는 옷이 모두 들어가야 합니다. 즉, 옷을 2개만 담은 상자는 배송할 수 없습니다.
보내야 할 옷의 개수 n이 주어질 때, 배송비를 최소화할 수 있는 상자의 개수를 return하도록 solution 함수를 완성하세요.
어떠한 방법으로도 모든 옷을 보낼 수 없다면 -1을 반환하면 됩니다.

제한사항
옷의 개수 n : 3 ≤ n ≤ 1,000,000,000
 */

import java.util.HashMap;
import java.util.Map;

public class Problem02 {
    static class Solution {
        public int solution(int n) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 0);
            map.put(1, -1);
            map.put(2, -1);
            map.put(3, 1);
            map.put(4, -1);
            map.put(5, 1);

            for (int i = 6; i <= n; i++) {
                if (map.get(i - 5) >= 0) {
                    map.put(i, map.get(i - 5) + 1);
                    continue;
                } else if (map.get(i - 3) >= 0) {
                    map.put(i, map.get(i - 3) + 1);
                } else {
                    map.put(i, -1);
                }
            }
            return map.get(n);
        }
    }

    static class Solution2 {
        public int solution(int n) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 0);
            map.put(1, -1);
            map.put(2, -1);
            map.put(3, 1);
            map.put(4, -1);
            map.put(5, 1);

            for (int i = 6; i <= n; i++) {
                if (map.get(i - 5) >= 0) {
                    map.put(i, map.get(i - 5) + 1);
                    continue;
                } else if (map.get(i - 3) >= 0) {
                    map.put(i, map.get(i - 3) + 1);
                } else {
                    map.put(i, -1);
                }
            }
            return map.get(n);

        }
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.solution(15));
        System.out.println(s.solution(7));
    }
}
