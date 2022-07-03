import java.util.*;
import java.util.Deque;

public class GraphArrayList {
    private final ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public GraphArrayList(int size) {
        for (int i = 0; i <= size; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public void connect(int node1, int node2) {
        graph.get(node1).add(node2);
    }

    public void disConnect(int node1, int node2) {
        graph.get(node1).remove((Integer) node2);
    }

    public List<Integer> printBFS(int node) {
        List<Integer> result = new ArrayList<Integer>(){{add(node);}};
        Queue<Integer> queue = new LinkedList<>();
        int[] v = new int[graph.size()];
        queue.add(node);
        while (!queue.isEmpty()) {
            v[queue.peek()] = 1;
            for (int connectedNode : graph.get(queue.poll())) {
                if (v[connectedNode] == 0) {
                    queue.add(connectedNode);
                    result.add(connectedNode);
                    v[connectedNode] = 1;
                }
            }
        }
        return result;
    }

    public List<Integer> printDFS(int node) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> queue = new LinkedList<Integer>();
        int[] v = new int[graph.size()];
        queue.addFirst(node);
        while (!queue.isEmpty()) {
            result.add(queue.peekLast());
            v[queue.peekLast()] = 1;
            for (int connectedNode : graph.get(queue.removeLast())) {
                if (v[connectedNode] == 0) {
                    queue.addLast(connectedNode);
                    v[connectedNode] = 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        GraphArrayList g = new GraphArrayList(10);
        g.connect(0, 1);
        g.connect(0, 2);
        g.connect(1, 2);
        g.connect(1, 6);
        g.connect(2, 0);
        g.connect(2, 3);
        g.connect(3, 3);
        g.connect(3, 4);
        System.out.println(g.printBFS(2));
        System.out.println("/////");
        g = new GraphArrayList(10);

        g.connect(0, 1);
        g.connect(0, 2);
        g.connect(1, 2);
        g.connect(1, 6);
        g.connect(2, 0);
        g.connect(2, 3);
        g.connect(3, 3);
        g.connect(3, 4);


        System.out.println(g.printDFS(2));
    }
}
