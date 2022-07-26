package leetcode;


/*
 * Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: 3

Example 2:

Input: root = [1,null,2]
Output: 2

 

Constraints:

    The number of nodes in the tree is in the range [0, 104].
    -100 <= Node.val <= 100


 */
public class MaximumDepthOfBinaryTree {

	private static int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		int left = maxDepth(root.left) + 1;
		int right = maxDepth(root.right) + 1;
		return left > right ? left : right;
	}

	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2));
		TreeNode root2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)),
				new TreeNode(3, null, new TreeNode(7)));
		System.out.println(maxDepth(root1));
		System.out.println(maxDepth(root2));
	}

	private static class TreeNode {
		@Override
		public String toString() {
			return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
		}

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
