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
        ListNode ptr = head;
        int count = 1;
        while (ptr.next != null) {
            ptr = ptr.next;
            count++;
        }
        ListNode tail = ptr;

        ListNode next = head.next;
        for (int i = 0; i < count / 2; i++) {

        }


        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(new ListNode(1).n(2).n(3).n(2).n(1)));
        System.out.println(isPalindrome(new ListNode(1).n(2).n(2).n(1)));
        System.out.println(isPalindrome(new ListNode(1)));
        System.out.println(isPalindrome(new ListNode(1).n(2)));
    }
}
