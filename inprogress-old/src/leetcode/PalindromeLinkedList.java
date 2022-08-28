package leetcode;

import leetcode.Merge2SortedLinkedList.ListNode;

/*
Given the head of a singly linked list, return true if it is a palindrome.

Example 1:

Input: head = [1,2,2,1]
Output: true

Example 2:

Input: head = [1,2]
Output: false



Constraints:

    The number of nodes in the list is in the range [1, 105].
    0 <= Node.val <= 9


Follow up: Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {

    private static boolean isPalindrome(ListNode head) {
        ListNode tail = head;
        int count = 0;
        // Count nodes and get tail node
        while (tail.next != null) {
            tail = tail.next;
            count++;
        }

        // Move to middle node
        ListNode midPtr = head;
        for (int i = 0; i < (count / 2); i++) {
            midPtr = midPtr.next;
        }

        reversLinkedList(midPtr.next);
        midPtr.next = null;
        // compare tail and head linked list
        while (tail != null && head != null)
            if (tail.val != head.val)
                return false;
            else {
                tail = tail.next;
                head = head.next;
            }
        return true;
    }

    private static void reversLinkedList(ListNode ptr) {
        // revers linkedList before middle node
        ListNode pre = null;
        ListNode cur = ptr;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(new ListNode(1).n(2).n(3).n(2).n(1)));
        System.out.println(isPalindrome(new ListNode(1).n(2).n(2).n(1)));
        System.out.println(isPalindrome(new ListNode(1)));
        System.out.println(isPalindrome(new ListNode(1).n(2)));
        System.out.println(isPalindrome(new ListNode(1).n(2).n(3).n(1)));
    }
}
