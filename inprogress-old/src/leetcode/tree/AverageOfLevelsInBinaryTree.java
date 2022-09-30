package leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*

Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.

 

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: [3.00000,14.50000,11.00000]
Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
Hence return [3, 14.5, 11].

Example 2:

Input: root = [3,9,20,15,7]
Output: [3.00000,14.50000,11.00000]

 

Constraints:

    The number of nodes in the tree is in the range [1, 104].
    -231 <= Node.val <= 231 - 1

 */
public class AverageOfLevelsInBinaryTree {
	private static List<Double> averageOfLevels(TreeNode root) {
		List<Double> result = new ArrayList<>();
		Queue<TreeNode> s1 = new LinkedList<>();
		if (root != null)
			s1.add(root);
		while (!s1.isEmpty()) {
			double sum = 0;
			int n = s1.size();
			for (int i = 0; i < n; i++) {
				TreeNode node = s1.remove();
				sum += node.val;
				if (node.left != null)
					s1.add(node.left);
				if (node.right != null)
					s1.add(node.right);
			}
			result.add(sum / n);
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(
				averageOfLevels(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))))); // [3,,,14.5,,,11]
		System.out.println(
				averageOfLevels(new TreeNode(3, new TreeNode(9, new TreeNode(15), new TreeNode(7)), new TreeNode(20)))); // [3,,,,14.5,,,,,11]
	}
}
