package leetcode.tree;

/*

Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

 

Example 1:

Input: p = [1,2,3], q = [1,2,3]
Output: true

Example 2:

Input: p = [1,2], q = [1,null,2]
Output: false

Example 3:

Input: p = [1,2,1], q = [1,1,2]
Output: false

 */
public class SameTree {

	private static boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p == null ^ q == null)
			return false;
		if (p.val != q.val)
			return false;
		if (!isSameTree(p.left, q.left))
			return false;
		if (!isSameTree(p.right, q.right))
			return false;
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isSameTree(new TreeNode(1, new TreeNode(2), new TreeNode(3)),
				new TreeNode(1, new TreeNode(2), new TreeNode(3))));// true
		System.out.println(isSameTree(new TreeNode(1, new TreeNode(2), new TreeNode(3)),
				new TreeNode(1, new TreeNode(2), new TreeNode(3, null, new TreeNode(4))))); // false
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
	}
}
