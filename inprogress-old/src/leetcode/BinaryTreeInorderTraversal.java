package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
Given the root of a binary tree, return the inorder traversal of its nodes' values.

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
public class BinaryTreeInorderTraversal {
    private static List<Integer> inorderTraversal(TreeNode root) {
        return inorderTraversal(root, new ArrayList<>());
    }

    private static List<Integer> inorderTraversal(TreeNode root, List<Integer> r) {
        if (root == null)
            return r;
        inorderTraversal(root.left, r);
        r.add(root.val);
        inorderTraversal(root.right, r);
        return r;
    }

    public static void main(String[] args) {
        System.out.println(inorderTraversal(new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3)))));
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
