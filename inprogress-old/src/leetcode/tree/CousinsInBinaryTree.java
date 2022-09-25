package leetcode.tree;

import static leetcode.tree.TreeNode.fromArray;

/*
Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.

Two nodes of a binary tree are cousins if they have the same depth with different parents.

Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.



Example 1:

Input: root = [1,2,3,4], x = 4, y = 3
Output: false

Example 2:

Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true

Example 3:

Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false



Constraints:

    The number of nodes in the tree is in the range [2, 100].
    1 <= Node.val <= 100
    Each node has a unique value.
    x != y
    x and y are exist in the tree.


 */
public class CousinsInBinaryTree {
    /*
        cases:
        1 - not on same level
        2 - have the same parent
        3 - x or y doesn't exist
     */
    private static boolean isCousins(TreeNode root, int x, int y) {
        if (root == null)
            return false;
        int xPath = findPath(root, x, 1);
        int yPath = findPath(root, y, 1);
        if ((xPath ^ yPath) == 1)
            return false;
        for (int i = 64; i > 0; i /= 2) {
            if ((xPath & i) > 0) {
                if ((yPath & i) > 0)
                    return true;
                else
                    return false;
            } else if ((yPath & i) > 0) {
                if ((xPath & i) > 0)
                    return true;
                else
                    return false;
            }
        }
        return false;
    }

    private static int findPath(TreeNode node, int x, int p) {
        if (node == null) {
            return -1;
        }
        if (node.val == x) {
            return p;
        }
        int path = findPath(node.left, x, p * 2);
        if (path != -1) {
            path = findPath(node.right, x, p * 2 + 1);
            if (path != -1)
                return path;
            return path;
        }
        path = findPath(node.right, x, p * 2 + 1);
        if (path != -1)
            return path;
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(isCousins(new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)), 4, 3));//false
        System.out.println(isCousins(new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4, null, new TreeNode(5))), 5, 1));//true
        System.out.println(isCousins(new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5))), 4, 5));//false
        System.out.println(isCousins(new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3)), 3, 2)); // false
        System.out.println(isCousins(new TreeNode(10, new TreeNode(1, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(5), new TreeNode(6))), 4, 5)); // true
        Integer[] tree = new Integer[]{1, 2, 5, 3, 8, 9, 6, 14, 4, 13, 12, 17, 16, 25, 7, 22, 41, 10, 11, 24, null, 29, 39, null, 45, 47, 67, 38, 35, 60, 15, 32, null, 48, null, 43, 20, null, 18, 87, 30, 49, null, 53, 88, 54, null, null, null, null, null, null, 77, 37, 70, 84, 90, 23, 19, null, 42, 57, null, null, 59, 21, 26, 40, 36, 94, null, 33, 51, 74, null, 61, null, null, null, null, 64, null, null, 50, 52, null, 72, null, null, null, null, 28, 56, 34, 27, 58, 68, 93, null, 83, 85, 71, 75, 46, 55, 91, 62, 99, null, null, null, 65, null, 73, null, null, 96, null, null, null, null, null, null, null, 92, null, null, null, null, null, 66, 76, 80, 69, 31, null, 82, null, null, null, 100, null, null, null, null, null, 95, null, 89, null, 78, 79, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 86, 81, null, null, 44, 98, null, null, null, 97, null, null, null, null, null, null, null, null, null, null, null, null, 63};
        System.out.println(isCousins(fromArray(tree), 55, 58)); // true
    }
}
