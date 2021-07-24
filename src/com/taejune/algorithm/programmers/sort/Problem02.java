package com.taejune.algorithm.programmers.sort;

import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/42746
public class Problem02 {

    /*
    case01: [79, 76, 7, 98, 89, 0, 309, 88]

    9 -> 98
    8 -> 89, 88
    7 -> 79, 7, 76
    6 ->
    5 ->
    4 ->
    3 -> 309
    2 ->
    1 ->
    0 ->
     */
    public static class Solution {

        class OrderNode {
            private OrderNode[] children;
            private boolean isLeaf;
            private boolean hasChild;
            private int v;

            public OrderNode(int value) {
                v = value;
                hasChild = false;
                isLeaf = false;
                children = new OrderNode[10];
            }

            public int getValue() {
                return v;
            }

            public OrderNode push(int value) {
                this.hasChild = true;
                if (children[value] == null) {
                    children[value] = new OrderNode(value);
                    return children[value];
                }
                return children[value];
            }

            public OrderNode setLeaf() {
                isLeaf = true;
                return this;
            }

            private OrderNode getBiggestChild() {
                for (int i = 9; i >= 0; i--) {
                    if (children[i] == null) continue;
                    return children[i];
                }
                System.out.println("[WARN] Try to get child even though not hasn't");
                return null;
            }

            public String popBiggestChildNodeValue() {
                String s = "";
                if (!hasChild && !isLeaf) {
                    System.out.println("[WARN]: it's not leaf but has no child");
                    return s;
                } else if (!hasChild && isLeaf) {
                    isLeaf = false;
                    return s + v;
                }

                OrderNode child = this.getBiggestChild();
                if (isLeaf) {
                    if (v > child.getValue()) {
                        isLeaf = false;
                        return s + v;
                    } else if (v == child.getValue()) {
                        if(v >= child.getBiggestChild().getValue()) {
                            isLeaf = false;
                            return s + v;
                        } else {
                            return s + v + child.popBiggestChildNodeValue();
                        }
                    }
                    // if v < child.getValue(), it can handle case.
                }
                return s + v + child.popBiggestChildNodeValue();
            }
        }

        public String solution(int[] numbers) {
            OrderNode root = new OrderNode(-1);
            for (int e : numbers) {
                OrderNode cur = root;
                ArrayList<Integer> orders = getOrderNumberList(Integer.toString(e));
                System.out.println("push " + orders.toString());
                for (int n : orders) {
                    cur = cur.push(n);
                }
                cur.setLeaf();
            }

            String answer = "";
            System.out.println("answer: " + root.popBiggestChildNodeValue());
            System.out.println("answer: " + root.popBiggestChildNodeValue());
            System.out.println("answer: " + root.popBiggestChildNodeValue());
            System.out.println("answer: " + root.popBiggestChildNodeValue());
            return answer;
        }


        private ArrayList<Integer> getOrderNumberList(String number) {
            ArrayList<Integer> l = new ArrayList<>(number.length());
            for (int i = 0; i < number.length(); i++) {
                l.add(Character.getNumericValue(number.charAt(i)));
            }
            return l;
        }
    }

    public static void main(String[] args) {
        String case01 = new Solution().solution(new int[]{1, 2, 3});
        assert case01.equals("321");
        System.out.println(case01);

        String case02 = new Solution().solution(new int[]{6, 10, 2});
        assert case02.equals("6210");
        System.out.println(case02);

        String case03 = new Solution().solution(new int[]{3, 30, 34, 5, 9});
        assert case03.equals("9534330");
        System.out.println(case03);
    }
}
