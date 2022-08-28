package leetcode.tree;

/*
Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p 
and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant
 of itself).”
 
Example 1:

	Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
	Output: 6
	Explanation: The LCA of nodes 2 and 8 is 6.

Example 2:

	Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
	Output: 2
	Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

Example 3:

	Input: root = [2,1], p = 2, q = 1
	Output: 2

 

Constraints:

    The number of nodes in the tree is in the range [2, 105].
    -109 <= Node.val <= 109
    All Node.val are unique.
    p != q
    p and q will exist in the BST.

 */
public class LowestCommonAncestor {

	private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root.val > p.val && root.val > q.val)
			return lowestCommonAncestor(root.left, p, q);
		if (root.val < p.val && root.val < q.val)
			return lowestCommonAncestor(root.right, p, q);
		if (root.val >= p.val && root.val <= q.val)
			return root;
		if (root.val <= p.val && root.val >= q.val)
			return root;
		return null;
	}

	private static TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
		while ((root.val - p.val) * (root.val - q.val) > 0)
			root = root.val > p.val ? root.left : root.right;
		return root;
	}

	public static void main(String[] args) {
		// 6,2,8, 0,4,7,9,null,null,3,5
		System.out
				.println(
						lowestCommonAncestor(
								new TreeNode(6,
										new TreeNode(2, new TreeNode(0),
												new TreeNode(4, new TreeNode(3), new TreeNode(5))),
										new TreeNode(8, new TreeNode(7), new TreeNode(9))),
								new TreeNode(2), new TreeNode(9)).val); // 6
		System.out
				.println(
						lowestCommonAncestor(
								new TreeNode(6,
										new TreeNode(2, new TreeNode(0),
												new TreeNode(4, new TreeNode(3), new TreeNode(5))),
										new TreeNode(8, new TreeNode(7), new TreeNode(9))),
								new TreeNode(2), new TreeNode(0)).val); // 2
		System.out
		.println(
				lowestCommonAncestorIterative(
						new TreeNode(6,
								new TreeNode(2, new TreeNode(0),
										new TreeNode(4, new TreeNode(3), new TreeNode(5))),
								new TreeNode(8, new TreeNode(7), new TreeNode(9))),
						new TreeNode(2), new TreeNode(9)).val); // 6
System.out
		.println(
				lowestCommonAncestorIterative(
						new TreeNode(6,
								new TreeNode(2, new TreeNode(0),
										new TreeNode(4, new TreeNode(3), new TreeNode(5))),
								new TreeNode(8, new TreeNode(7), new TreeNode(9))),
						new TreeNode(2), new TreeNode(0)).val); // 2

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
