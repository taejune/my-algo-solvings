package com.taejune.algorithm.zigbang;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Problem03 {
    static class Solution {

        final static int OPER_END_TIME = 1000;

        public String solution(int total, int[][] data) {
            Map<Integer, List<Integer>> enter = new HashMap<>();
            Map<Integer, List<Integer>> leave = new HashMap<>();
            for (int i = 0; i < data.length; i++) {
                List entered = enter.getOrDefault(data[i][1], new ArrayList<>());
                entered.add(data[i][0]);
                enter.put(data[i][1], entered);

                List leaved = leave.getOrDefault(data[i][2], new ArrayList<>());
                leaved.add(data[i][0]);
                leave.put(data[i][2], leaved);
            }

            SingleQuotaToilet t = new SingleQuotaToilet();
            for (int i = 1; i <= OPER_END_TIME; i++) {

                List tryIns = enter.get(i);
                if (tryIns != null && !tryIns.isEmpty()) {
                    for (int j = 0; j < tryIns.size(); j++) {
                        t.enter((Integer) tryIns.get(j));
                    }
                }
                List tryOuts = leave.get(i);
                if (tryOuts != null && !tryOuts.isEmpty()) {
                    for (int j = 0; j < tryOuts.size(); j++) {
                        t.leave((Integer) tryOuts.get(j));
                    }
                }
            }

            System.out.println(t.nUsers());
            System.out.println(t.maxConcurrentUsers());
            return "";
        }

        class SingleQuotaToilet {
            private int count = 0;
            private int nConcurrent = 0;
            private int maxConcurrent = 0;
            private boolean occupied = false;
            private int occupierID;

            public boolean enter(int id) {
                nConcurrent++;
                maxConcurrent = Math.max(maxConcurrent, nConcurrent);

                if (occupied) {
                    return false;
                }
                occupierID = id;
                count++;
                occupied = true;
                return true;
            }

            public boolean leave(int id) {
                nConcurrent--;
                if (occupied && occupierID == id) {
                    occupied = false;
                    return true;
                }
                return false;
            }

            public int nUsers() {
                return count;
            }

            public int maxConcurrentUsers() {
                return maxConcurrent;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nUsers = Integer.parseInt(br.readLine());

        int[][] data = new int[nUsers][];
        for(int i=0; i<nUsers; i++) {
            int[] dat = new int[3];
            String entry = br.readLine();
            StringTokenizer st = new StringTokenizer(entry, " ");

            for(int j=0; j<3; j++) {
                dat[j] = Integer.parseInt(st.nextToken());
            }
            data[i] = dat;
        }

        System.out.println(new Solution().solution(nUsers, data));


//        String case01 = new Solution().solution(5, new int[][]{new int[]{1, 3, 5}, new int[]{2, 2, 4}, new int[]{3, 5, 6}, new int[]{4, 7, 8}, new int[]{5, 7, 10}});
//        System.out.println("solve: " + case01);
////        assert case01.equals(); 3, 2
//
//        String case02 = new Solution().solution(11, new int[][]{new int[]{1, 3, 5}, new int[]{2, 1, 4}, new int[]{3, 5, 7},
//                new int[]{4, 0, 6}, new int[]{5, 3, 8}, new int[]{6, 5, 9}, new int[]{7, 6, 10}, new int[]{8, 8, 11}, new int[]{9, 8, 12}, new int[]{10, 2, 13}, new int[]{11, 12, 24}});
//        System.out.println("solve: " + case02);
////        assert case02.equals(); 4, 5
    }
}
