package geek.basic;

public class ReverseLinkedList {
    private static NodeList revers(NodeList node) {
        if (node == null || node.next == null)
            return node;
        NodeList head = revers(node.next);
        node.next.next = node;
        node.next = null;
        return head;
    }

    public static void main(String[] args) {
        System.out.println(revers(new NodeList(null, 1).n(2).n(3)));
    }

    private static class NodeList {
        NodeList next;
        int val;

        public NodeList(NodeList next, int val) {
            this.next = next;
            this.val = val;
        }

        public NodeList n(int val) {
            NodeList ptr = this;
            while (ptr.next != null)
                ptr = ptr.next;
            ptr.next = new NodeList(null, val);
            return this;
        }

        @Override
        public String toString() {
            return "NodeList{" +
                    ", val=" + val +
                    "next=" + (next != null ? next : "null") +

                    '}';
        }

    }
}
