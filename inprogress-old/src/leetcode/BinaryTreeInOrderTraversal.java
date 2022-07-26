package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/*
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.

Example 1:

Input: root = [1,null,2,3]
Output: [1,3,2]

Example 2:

Input: root = []
Output: []

Example 3:

Input: root = [1]
Output: [1]

 

Constraints:

    The number of nodes in the tree is in the range [0, 100].
    -100 <= Node.val <= 100

 
Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInOrderTraversal {

	private static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new LinkedList<>();
		TreeNode cur = root;
		Deque<TreeNode> stack = new LinkedList<>();

		while (cur != null || !stack.isEmpty()) {
			while (cur != null) {
				stack.addFirst(cur);
				cur = cur.left;
			}
			cur = stack.removeFirst();
			result.add(cur.val);
			cur = cur.right;
		}
		return result;
	}

	private static List<Integer> inorderTraversalRecursive(TreeNode root) {
		return inOrder(root, new LinkedList<>());
	}

	private static List<Integer> inOrder(TreeNode node, List<Integer> result) {
		if (node == null)
			return result;
		inOrder(node.left, result);
		result.add(node.val);
		inOrder(node.right, result);
		return result;
	}

	public static void main(String[] args) {

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
