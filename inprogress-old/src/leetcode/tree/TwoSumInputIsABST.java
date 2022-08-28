package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/*
Given the root of a Binary Search Tree and a target number k,

return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:

    Input: root = [5,3,6,2,4,null,7], k = 9
    Output: true

Example 2:

    Input: root = [5,3,6,2,4,null,7], k = 28
    Output: false



Constraints:

    The number of nodes in the tree is in the range [1, 104].
    -104 <= Node.val <= 104
    root is guaranteed to be a valid binary search tree.
    -105 <= k <= 105


 */
public class TwoSumInputIsABST {

    private static boolean findTarget(TreeNode root, int k) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            TreeNode n = que.remove();
            if (find(root, k - n.val))
                return true;
            if (n.left != null)
                que.add(n.left);
            if (n.right != null)
                que.add(n.right);
        }
        return false;
    }

    private static boolean find(TreeNode root, int k) {
        TreeNode p = root;
        while (p != null) {
            if (root.val == k)
                return true;
            if (root.val < k)
                p = p.right;
            if (root.val > k)
                p = p.left;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(findTarget(new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)), new TreeNode(6, null, new TreeNode(7))), 9));
        System.out.println(findTarget(new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)), new TreeNode(6, null, new TreeNode(7))), 28));
    }
}
