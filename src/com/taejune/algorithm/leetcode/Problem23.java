package com.taejune.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/merge-k-sorted-lists/
public class Problem23 {
    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length < 1) {
                return null;
            }
            if (lists.length == 1) {
                return lists[0];
            }

            ListNode merged = merge(lists[0], lists[1]);
            ListNode[] newlists = new ListNode[lists.length - 1];
            newlists[0] = merged;
            for (int i = 1; i < lists.length - 1; i++) {
                newlists[i] = lists[i + 1];
            }

            return mergeKLists(newlists);
        }

        ListNode merge(ListNode a, ListNode b) {
            if (a == null && b == null) {
                return null;
            }

            ListNode merged = new ListNode();
            ListNode ptr = merged;

            while (a != null && b != null) {
                if (a.val <= b.val) {
                    ptr.val = a.val;
                    a = a.next;
                } else {
                    ptr.val = b.val;
                    b = b.next;
                }
                ptr.next = new ListNode();
                ptr = ptr.next;
            }

            if (a != null) {
                while (a != null) {
                    ptr.val = a.val;
                    a = a.next;
                    if (a != null) {
                        ptr.next = new ListNode();
                        ptr = ptr.next;
                    }
                }
            } else {
                while (b != null) {
                    ptr.val = b.val;
                    b = b.next;
                    if (b != null) {
                        ptr.next = new ListNode();
                        ptr = ptr.next;
                    }
                }
            }

            return merged;
        }
    }

    /**
     * Definition for singly-linked list.
     */
    static class ListNode {
        ListNode next;
        int val;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode n2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode n3 = new ListNode(2, new ListNode(6));
        ListNode case01 = new Solution().mergeKLists(new ListNode[]{n1, n2, n3});
        printListNode(case01);

        ListNode case02 = new Solution().mergeKLists(null);
        printListNode(case02);

        ListNode case03 = new Solution().mergeKLists(new ListNode[]{null, null});
        printListNode(case03);

    }

    public static void printListNode(ListNode node) {
        StringBuilder sb = new StringBuilder();
        if (node == null) {
            sb.append("[]");
        } else {
            while (node != null) {
                sb.append(String.format("%d->", node.val));
                node = node.next;
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        System.out.println(sb);
    }
}