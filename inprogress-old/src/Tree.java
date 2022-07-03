import java.util.*;
import java.util.Deque;
import java.util.function.Function;

public class Tree {

    private Node parent;

    public void addNode(int value) {
        if (parent != null) {
            Node newNode = new Node(value);
            Node currentNode = parent;
            while (true) {
                if (newNode.value > currentNode.value) {
                    if (currentNode.right == null) {
                        currentNode.right = newNode;
                        break;
                    } else {
                        currentNode = currentNode.right;
                    }
                }
                if (newNode.value < currentNode.value) {
                    if (currentNode.left == null) {
                        currentNode.left = newNode;
                        break;
                    } else {
                        currentNode = currentNode.left;
                    }
                }
            }
        } else {
            parent = new Node(value);
        }
    }

    public List<Node> bfs() {
        List<Node> result = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(parent);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            result.add(node);
            if (node.right != null)
                queue.add(node.right);
            if (node.left != null)
                queue.add(node.left);
        }
        return result;
    }

    public List<Node> dfs(Node node) {
        if (node == null)
            return Collections.emptyList();
        List<Node> result = new LinkedList<>();
        result.addAll(dfs(node.left));
        result.add(node);
        result.addAll(dfs(node.right));
        return result;
    }


    public Node[] connectPreNextPtr() {
        return new Function<Node, Node[]>() {
            Node pre;
            Node head;

            @Override
            public Node[] apply(Node node) {
                if (node == null)
                    return new Node[]{head, null};
                apply(node.left);
                node.pre = pre;
                if (pre != null)
                    pre.next = node;
                if (head == null)
                    head = node;
                pre = node;
                apply(node.right);
                return new Node[]{head, pre};
            }
        }.apply(parent);
    }

    public int height(Node node) {
        if (node == null)
            return 0;
        int leftHeight = height(node.left) + 1;
        int rightHeight = height(node.right) + 1;
        return Math.max(leftHeight, rightHeight);
    }

    public Node[][] levelsPrint() {
        Node[][] result = new Node[height(parent)][(int) Math.pow(2, height(parent) - 1)];
        int row = 0;
        int col = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(parent);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node == null) {
                row++;
                col = 0;
                if (!queue.isEmpty())
                    queue.add(null);
                continue;
            }
            result[row][col++] = node;
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
        return result;
    }

    private class Node {
        private int value;
        private Node left;
        private Node right;
        private Node pre;
        private Node next;

        private Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "" + value;
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.addNode(6);
        tree.addNode(4);
        tree.addNode(5);
        tree.addNode(2);
        tree.addNode(3);
        tree.addNode(1);
        tree.addNode(7);
        tree.addNode(8);
        tree.addNode(9);
        List<Node> bfs = tree.bfs();
        System.out.println("bfs");
        System.out.println(bfs);
        List<Node> dfs = tree.dfs(tree.parent);
        System.out.println("dfs");
        System.out.println(dfs);
        Node node = tree.connectPreNextPtr()[1];
        System.out.println("linked list, start from tail");
        while (node != null) {
            System.out.print(node + (node.pre == null ? "" : " , "));
            node = node.pre;
        }
        System.out.println();
        System.out.println("linked list, start from head");
        node = tree.connectPreNextPtr()[0];
        while (node != null) {
            System.out.print(node + (node.next == null ? "" : " , "));
            node = node.next;
        }
        System.out.println();
        System.out.println("Height");
        System.out.println(tree.height(tree.parent));
        System.out.println("Level print");
        Arrays.stream(tree.levelsPrint()).forEach(
                (x) -> {
                    Arrays.stream(x).forEach(
                            (y) -> {
                                if (y != null) System.out.print(y + " ,");
                            }
                    );
                    System.out.println();
                }
        );
    }
}
