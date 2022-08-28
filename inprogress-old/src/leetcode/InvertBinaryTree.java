package leetcode;

/*
Given the root of a binary tree, invert the tree, and return its root.



Example 1:

Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]

Example 2:

Input: root = [2,1,3]
Output: [2,3,1]

Example 3:

Input: root = []
Output: []

Constraints:
    The number of nodes in the tree is in the range [0, 100].
    -100 <= Node.val <= 100
 */
public class InvertBinaryTree {

    private static TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        System.out.println(invertTree(new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(6), new TreeNode(9)))));
        // intput : 4,2,7,1,3,6,9 . output : 4,7,2,9,6,3,1
        System.out.println(invertTree(new TreeNode(2, new TreeNode(1), new TreeNode(3))));
        // intput : 2,1,3 . output : 2,3,1
        System.out.println(invertTree(new TreeNode(4)));
        // intput : 4 . output : 4
        System.out.println(invertTree(null));
        // intput : null . output : null
        System.out.println(invertTree(new TreeNode(4, new TreeNode(2, new TreeNode(5), null), null)));
        // intput : 4,2,5 . output : 4,2,5
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

        private TreeNode l(int val) {
            TreeNode node = new TreeNode(val);
            this.left = node;
            return node;
        }

        private TreeNode r(int val) {
            TreeNode node = new TreeNode(val);
            this.right = node;
            return node;
        }

        private TreeNode root() {
            return this;
        }

        @Override
        public String toString() {
            return val + ", " + (left != null ? left.toString() : "") + ", " + (right != null ? right.toString() : "");
        }
    }
}
