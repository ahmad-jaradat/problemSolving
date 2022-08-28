package leetcode.linkedlist;

/*
 * Given the head of a linked list and an integer val, 
 * remove all the nodes of the linked list that has Node.val == val, and return the new head.
 * 
 * Example 1:
 * Input: head = [1,2,6,3,4,5,6], val = 6
 * Output: [1,2,3,4,5]
 * 
 * 
 * Example 2:
 * Input: head = [], val = 1
 * Output: []

 * Example 3:
 * Input: head = [7,7,7,7], val = 7
 * Output: []

 */
public class RemoveLinkedLisElements {

	private static ListNode removeElements(ListNode head, int val) {
		while (head != null && head.val == val) {
			head = head.next;
		}
		ListNode pre;
		ListNode ptr = head;
		while (ptr != null) {
			pre = ptr;
			ptr = ptr.next;
			while (ptr != null && ptr.val == val) {
				ptr = ptr.next;
			}
			pre.next = ptr;
		}
		return head;
	}

	private static ListNode removeElementsRe(ListNode head, int val) {
		if (head == null)
			return null;
		if (head.val != val) {
			head.next = removeElements(head.next, val);
			return head;
		}
		return removeElements(head.next, val);
	}

	public static void main(String[] args) {
		System.out.println(removeElements(new ListNode(1).n(2).n(6).n(3).n(4).n(5).n(6), 6));
		System.out.println(removeElements(null, 6));
		System.out.println(removeElements(new ListNode(7).n(7).n(7).n(7).n(7), 7));
		// Recursive solution
		System.out.println(removeElementsRe(new ListNode(1).n(2).n(6).n(3).n(4).n(5).n(6), 6));
		System.out.println(removeElementsRe(null, 6));
		System.out.println(removeElementsRe(new ListNode(7).n(7).n(7).n(7).n(7), 7));
	}
}
