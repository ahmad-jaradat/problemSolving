package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/*
 Given the root of a binary tree, return all root-to-leaf paths in any order.

A leaf is a node with no children.

 

Example 1:

	Input: root = [1,2,3,null,5]
	Output: ["1->2->5","1->3"]

Example 2:

	Input: root = [1]
	Output: ["1"]

 

Constraints:

    The number of nodes in the tree is in the range [1, 100].
    -100 <= Node.val <= 100


 */
public class BinaryTreePaths {

	private static List<String> binaryTreePaths(TreeNode root) {
		return r(root, new ArrayList<>(), "");
	}

	private static List<String> r(TreeNode root, List<String> result, String path) {
		if (root == null)
			return result;
		if (root.left == null && root.right == null)
			result.add(path + (path.length() == 0 ? "" : "->") + root.val);
		else {
			path += path.length() == 0 ? root.val : ("->" + root.val);
			r(root.left, result, path);
			r(root.right, result, path);
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(binaryTreePaths(new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3))));
		System.out.println(binaryTreePaths(new TreeNode(1)));
	}
}
