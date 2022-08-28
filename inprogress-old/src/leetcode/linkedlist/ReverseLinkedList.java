package leetcode.linkedlist;

/*
Given the head of a singly linked list, reverse the list, and return the reversed list.

Example 1:

Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Example 2:

Input: head = [1,2]
Output: [2,1]

Example 3:

Input: head = []
Output: []

Constraints:

    The number of nodes in the list is the range [0, 5000].
    -5000 <= Node.val <= 5000

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

import java.util.List;

public class ReverseLinkedList {

    private static ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    private static ListNode reverseRecursion(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = reverseRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        System.out.println(reverse(new ListNode(1).next(2).next(3).next(4).next(5)));
        System.out.println(reverse(new ListNode(1)));
        System.out.println(reverseRecursion(new ListNode(1).next(2).next(3).next(4).next(5)));
        System.out.println(reverseRecursion(new ListNode(1)));
    }
}
