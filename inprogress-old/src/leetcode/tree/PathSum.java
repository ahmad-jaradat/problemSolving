package leetcode.tree;

/*
Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.

 

Example 1:

Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum is shown.

Example 2:

Input: root = [1,2,3], targetSum = 5
Output: false
Explanation: There two root-to-leaf paths in the tree:
(1 --> 2): The sum is 3.
(1 --> 3): The sum is 4.
There is no root-to-leaf path with sum = 5.

Example 3:

Input: root = [], targetSum = 0
Output: false
Explanation: Since the tree is empty, there are no root-to-leaf paths.

 */
public class PathSum {
	private static boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null && sum - root.val == 0)
			return true;
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}

	public static void main(String[] args) {
		System.out.println(hasPathSum(new TreeNode(1, new TreeNode(2), new TreeNode(3)), 4)); // true
		System.out.println(hasPathSum(new TreeNode(1, new TreeNode(2), new TreeNode(3)), 0)); // false
		System.out.println(hasPathSum(new TreeNode(1, new TreeNode(2), new TreeNode(3)), 3)); // true
		System.out.println(hasPathSum(new TreeNode(1, new TreeNode(2, null, new TreeNode(6)), new TreeNode(3)), 2)); // false
		System.out.println(hasPathSum(new TreeNode(1, new TreeNode(2, null, new TreeNode(6)), new TreeNode(3)), 9)); // true
		System.out.println(hasPathSum(new TreeNode(1, new TreeNode(2), null), 1)); // false
		System.out.println(hasPathSum(null, 1)); // false

	}

}
