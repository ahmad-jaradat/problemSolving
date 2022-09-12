package leetcode.tree;

/*

Given the root of a binary tree, return the sum of all left leaves.

A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.

 

Example 1:
	
	Input: root = [3,9,20,null,null,15,7]
	Output: 24
	Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.

Example 2:
	
	Input: root = [1]
	Output: 0

 
 */
public class SumOfLeftLeaves {

	private static int sumOfLeftLeaves(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left != null && root.left.left == null && root.left.right == null)
			return root.left.val + sumOfLeftLeaves(root.right);
		else
			return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
	}

	public static void main(String[] args) {
		System.out.println(
				sumOfLeftLeaves(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))))); // 24
		System.out.println(sumOfLeftLeaves(new TreeNode(1))); // 0
	}
}
