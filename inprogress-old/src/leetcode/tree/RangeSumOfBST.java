package leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;

/*
Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive range [low, high].

Example 1:

	Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
	Output: 32
	Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.

Example 2:

	Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
	Output: 23
	Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.
 */
public class RangeSumOfBST {
	private int rangeSumBST(TreeNode root, int low, int high) {
		int sum = 0;
		Deque<TreeNode> nodes = new LinkedList<>();
		if (root != null)
			nodes.add(root);
		while (!nodes.isEmpty()) {
			TreeNode node = nodes.removeFirst();
			if (node.val >= low && node.val <= high)
				sum += node.val;
			if (node.left != null)
				nodes.add(node.left);
			if (node.right != null)
				nodes.add(node.right);
		}
		return sum;
	}

	public static void main(String[] args) {

	}
}
