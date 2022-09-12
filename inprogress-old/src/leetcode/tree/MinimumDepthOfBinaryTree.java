package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.



Example 1:

    Input: root = [3,9,20,null,null,15,7]
    Output: 2

Example 2:

    Input: root = [2,null,3,null,4,null,5,null,6]
    Output: 5

Constraints:

    The number of nodes in the tree is in the range [0, 105].
    -1000 <= Node.val <= 1000


 */
public class MinimumDepthOfBinaryTree {
	static int minDepthRe(TreeNode root) {
		int depth = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		Queue<TreeNode> queue2 = new LinkedList<>();
		queue2.add(root);
		while (!queue2.isEmpty()) {
			depth++;
			queue = queue2;
			queue2 = new LinkedList<>();
			while (!queue.isEmpty()) {
				TreeNode c = queue.remove();
				if (c.left == c.right)
					return depth;
				else if (c.left != null)
					queue2.add(c.left);
				else
					queue2.add(c.right);
			}
		}
		return Integer.MAX_VALUE;
	}

	private static int minDepth(TreeNode root) {
		if (root == null)
			return 1;
		return minDepth(root, 1);
	}

	private static int minDepth(TreeNode root, int depth) {
		if (root == null)
			return Integer.MAX_VALUE;
		if (root.left == null && root.right == null)
			return depth;
		return Math.min(minDepth(root.left, ++depth), minDepth(root.right, depth));
	}

	public static void main(String[] args) {
		System.out.println(
				minDepth(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
		System.out.println(minDepth(new TreeNode(2, null,
				new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5, null, new TreeNode(6)))))));
		System.out.println(
				minDepthRe(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
		System.out.println(minDepthRe(new TreeNode(2, null,
				new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5, null, new TreeNode(6)))))));

	}
}
