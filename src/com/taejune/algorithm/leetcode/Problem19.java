package com.taejune.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem19 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public String toString() {
            String s;
            if (next == null) {
                s = String.format("(%d)", val);
            } else {
                s = String.format("(%d)-", val);
            }
            return s;
        }
    }

    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            Map<Integer, ListNode> dic = new HashMap<>();
            ListNode cur = head;
            int idx = 1;
            while (cur != null) {
                dic.put(idx++, cur);
                cur = cur.next;
            }

            ListNode prev = dic.get((n == dic.size()) ? -1 : dic.size() - n);
            ListNode next = dic.get((n == 1) ? -1 : dic.size() - n + 2);

            if (prev != null && next != null) {
                prev.next = next;
            } else if (prev == null) {
                head = next;
            } else if (next == null) {
                prev.next = null;
            } else {
                head = null;
            }

            return head;
        }
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        System.out.println("case01:");
        print(node1);
        ListNode case01 = new Solution().removeNthFromEnd(node1, 2);
        print(case01);
        // expect [1-2-3-5]

        System.out.println("case02:");
        node1 = new ListNode(1);
        ListNode case02 = new Solution().removeNthFromEnd(node1, 1);
        print(case02);
        // expect []

        System.out.println("case03:");
        node2 = new ListNode(2);
        node1 = new ListNode(1, node1);
        print(node1);
        ListNode case03 = new Solution().removeNthFromEnd(node1, 2);
        print(case03);
        // expect [1]
    }

    static void print(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur);
            cur = cur.next;
        }
        System.out.println();
    }
}