package leetcode;

/*
. Diameter of Binary Tree
Easy

Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.



Example 1:

Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].

Example 2:

Input: root = [1,2]
Output: 1



Constraints:

    The number of nodes in the tree is in the range [1, 104].
    -100 <= Node.val <= 100

 */
public class DiameterOfBinaryTree {

    private static int result = 0;

    private static int diameterOfBinaryTree(TreeNode root) {
        result = 0;
        dfs(root, 0);
        return result;
    }

    private static int dfs(TreeNode node, int level) {
        if (node == null)
            return level;
        level++;
        int left = dfs(node.left, level);
        int right = dfs(node.right, level);
        result = Math.max(left + right - 2 * level, result);
        return left > right ? left : right;
    }

    private static int diameterOfBinaryTree2(TreeNode root) {
        if (root == null)
            return 0;
        int left = diameterOfBinaryTree2(root.left);
        int right = diameterOfBinaryTree2(root.right);
        int lAndR = h(root.left) + h(root.right);
        int rOrL = (right > left ? right : left);
        return lAndR > rOrL ? lAndR : rOrL;
    }

    private static int h(TreeNode n) {
        if (n == null)
            return 0;
        int l = h(n.left);
        int r = h(n.right);
        return (l > r ? l : r) + 1;
    }

    public static void main(String[] args) {
        System.out.println(diameterOfBinaryTree(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3))));
        result = 0;
        System.out.println(diameterOfBinaryTree(new TreeNode(1, new TreeNode(2), null)));

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
