package leetcode.tree;

public class TreeNode {
    int val;
    public TreeNode left;
    public TreeNode right;

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

    @Override
    public String toString() {
        return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
    }

    static TreeNode fromArray(Integer[] array) {
        if (array.length == 0)
            return null;
        TreeNode root = new TreeNode(array[0]);
        fromArray(root, array, 2);
        return root;
    }

    private static void fromArray(TreeNode root, Integer[] array, int i) {
        if (root == null)
            return;
        if (i - 1 >= array.length)
            return;
        root.left = instance(array[i - 1]);
        fromArray(root.left, array, i * 2);
        if (i >= array.length)
            return;
        root.right = instance(array[i]);
        fromArray(root.right, array, (i + 1) * 2);
    }

    private static TreeNode instance(Integer val) {
        if (val == null)
            return null;
        return new TreeNode(val);
    }
}
