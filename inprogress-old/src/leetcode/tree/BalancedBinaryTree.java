package leetcode.tree;

/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

    a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

 

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: true


Input: root = [1,2,2,3,3,null,null,4,4]
Output: false

Example 3:

Input: root = []
Output: true

 */
public class BalancedBinaryTree {

	private static boolean isBalanced(TreeNode root) {
		return isBalancedRe(root) == -1 ? false : true;
	}

	private static int isBalancedRe(TreeNode root) {
		if (root == null)
			return 0;
		int left = isBalancedRe(root.left);
		if (left == -1)
			return -1;
		int right = isBalancedRe(root.right);
		if (right == -1)
			return -1;
		if (Math.abs(left - right) > 1)
			return -1;
		return 1 + Math.max(left, right);
	}

	public static void main(String[] args) {
		System.out.println(
				isBalanced(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))))); // true
		System.out.println(isBalanced(new TreeNode(1,
				new TreeNode(2, new TreeNode(3, new TreeNode(4), new TreeNode(4)), new TreeNode(3)), new TreeNode(2)))); // false
		System.out.println(isBalanced(null)); // true
		System.out.println(isBalanced(new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), null), null),
				new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4)))))); // false
	}

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
		}

	}
}
