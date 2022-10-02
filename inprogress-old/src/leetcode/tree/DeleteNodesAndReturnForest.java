package leetcode.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/*
Given the root of a binary tree, each node in the tree has a distinct value.

After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).

Return the roots of the trees in the remaining forest. You may return the result in any order.

Example 1:

Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
Output: [[1,2,null,4],[6],[7]]

Example 2:

Input: root = [1,2,4,null,3], to_delete = [3]
Output: [[1,2,4]]

Constraints:

    The number of nodes in the given tree is at most 1000.
    Each node has a distinct value between 1 and 1000.
    to_delete.length <= 1000
    to_delete contains distinct values between 1 and 1000.


 */
public class DeleteNodesAndReturnForest {
	private static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		List<TreeNode> deleteCandidates = new ArrayList<>();
		List<TreeNode> finalResult = new ArrayList<>();
		Set<Integer> toDelete = new HashSet<>();
		for (int i = 0; i < to_delete.length; i++)
			toDelete.add(to_delete[i]);
		listNodes(root, toDelete, deleteCandidates);
		if (!toDelete.contains(root.val))
			finalResult.add(root);
		while (!toDelete.isEmpty()) {
			for (TreeNode node : deleteCandidates) {
				if (toDelete.contains(node.val)) {
					addNodeToResult(node, toDelete, finalResult);

				}
			}
		}
		return finalResult;
	}

	private static void addNodeToResult(TreeNode root, Set<Integer> toDelete, List<TreeNode> result) {
		if (root == null)
			return;
		if (toDelete.contains(root.val)) {
			addNodeToResult(root.left, toDelete, result);
			addNodeToResult(root.right, toDelete, result);
			toDelete.remove(root.val);
		} else {
			result.add(root);
		}
	}

	private static void listNodes(TreeNode root, Set<Integer> toDelete, List<TreeNode> result) {
		if (root == null)
			return;
		if (toDelete.contains(root.val))
			result.add(root);
		listNodes(root.left, toDelete, result);
		listNodes(root.right, toDelete, result);
	}

	public static void main(String[] args) {
		System.out.println(delNodes(TreeNode.fromArray(new Integer[] { 1, 2, 3, 4, 5, 6, 7 }), new int[] { 3, 5 })); // [1,2,null,4],[6],[7]
		System.out.println(delNodes(TreeNode.fromArray(new Integer[] { 1, 2, 4, null, 3 }), new int[] { 3 })); // 1,2,4
	}
}
