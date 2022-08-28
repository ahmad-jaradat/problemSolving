package leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Preorder, Inorder, and Postorder Iteratively Summarization

Depth First Traversals: 
(a) Inorder (Left, Root, Right) : 4 2 5 1 3 
(b) Preorder (Root, Left, Right) : 1 2 4 5 3 
(c) Postorder (Left, Right, Root) : 4 5 2 3 1
 */
public class TreeAllTypeTraversal {

	private static List<Integer> preOrderTraversal(TreeNode node) {
		List<Integer> result = new ArrayList<>();
		TreeNode p = node;
		Queue<TreeNode> stack = new LinkedList<>();
		while (!stack.isEmpty() || p != null) {
			if (p != null) {
				stack.add(p);
				result.add(p.val);
				p = p.left;
			} else {
				p = stack.remove();
				p = p.right;
			}
		}
		return result;
	}

	private static List<Integer> inOrderTraversal(TreeNode node) {
		List<Integer> result = new ArrayList<>();
		TreeNode c = node;
		Deque<TreeNode> stack = new LinkedList<>();
		while (c != null && !stack.isEmpty()) {
			c = stack.removeFirst();
			result.add(c.val);
			if (c.left != null)
				stack.addLast(c.left);
			if (c.right != null)
				stack.addLast(c.right);
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(
				preOrderTraversal(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3))));
	}
}
