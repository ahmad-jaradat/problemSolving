package leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
Given the root of a binary tree, return the postorder traversal of its nodes' values.


Example 1:

	Input: root = [1,null,2,3]
	Output: [3,2,1]

Example 2:

	Input: root = []
	Output: []

Example 3:

	Input: root = [1]
	Output: [1]

 */
public class BinaryTreePostorderTraversal {

	private static List<Integer> postorderTraversal(TreeNode root) {
		return rec(root, new ArrayList<>());
	}

	private static List<Integer> rec(TreeNode root, List<Integer> result) {
		if (root == null)
			return result;
		rec(root.left, result);
		rec(root.right, result);
		result.add(root.val);
		return result;
	}

	public static void main(String[] args) {
		System.out.println(postorderTraversal(new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null))));
		System.out.println(postorderTraversal(null));
		System.out.println(postorderTraversal(new TreeNode(1)));
	}
}
