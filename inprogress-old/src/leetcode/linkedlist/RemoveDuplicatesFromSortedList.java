package leetcode.linkedlist;

/*
Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

Example 1:

	Input: head = [1,1,2]
	Output: [1,2]

Example 2:

	Input: head = [1,1,2,3,3]
	Output: [1,2,3]

 */
public class RemoveDuplicatesFromSortedList {

	private static ListNode deleteDuplicates(ListNode head) {
		ListNode ptr = head;
		while (ptr != null) {
			if (ptr.next != null && ptr.next.val == ptr.val)
				ptr.next = ptr.next.next;
			else
				ptr = ptr.next;
		}
		return head;
	}

	public static void main(String[] args) {
		System.out.println(deleteDuplicates(new ListNode(1).n(1).n(2)));
		System.out.println(deleteDuplicates(new ListNode(1).n(1).n(2).n(3).n(3)));
		System.out.println(deleteDuplicates(new ListNode(1).n(1).n(1)));
	}
}
