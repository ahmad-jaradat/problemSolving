package leetcode.linkedlist;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}

	public ListNode(int x, ListNode next) {
		this(x);
		this.next = next;
	}

	ListNode n(int val) {
		ListNode ptr = this;
		while (ptr.next != null)
			ptr = ptr.next;
		ptr.next = new ListNode(val);
		return this;
	}

	ListNode n(ListNode node) {
		ListNode ptr = this;
		while (ptr.next != null)
			ptr = ptr.next;
		ptr.next = node;
		return this;
	}

	@Override
	public String toString() {
		return ", " + val + next;
	}

	public ListNode next(int val) {
		ListNode ptr = this;
		while (ptr.next != null)
			ptr = ptr.next;
		ptr.next = new ListNode(val);
		return this;
	}
}