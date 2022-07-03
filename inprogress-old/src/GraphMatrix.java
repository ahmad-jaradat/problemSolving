import java.util.*;
import java.util.Deque;

public class GraphMatrix {

    private final boolean[][] g;

    public GraphMatrix(int size) {
        this.g = new boolean[size + 1][size + 1];
    }

    public void connect(int node1, int node2) {
        g[node1][node2] = true;
        g[node2][node1] = true;
    }

    public void disConnect(int node1, int node2) {
        g[node1][node2] = false;
        g[node2][node1] = false;
    }

    public List<Integer> printBFS(int node) {
        List<Integer> result = new LinkedList<Integer>() {{
            add(node);
        }};
        boolean[] v = new boolean[g.length];
        v[node] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        while (q.peek() != null) {
            boolean[] nodes = g[q.poll()];
            for (int i = 0; i < nodes.length; i++) {
                if (nodes[i] && !v[i]) {
                    result.add(i);
                    q.add(i);
                    v[i] = true;
                }
            }
        }
        return result;
    }

    public List<Integer> printDFS(int node) {
        List<Integer> result = new LinkedList<Integer>() ;
        boolean[] v = new boolean[g.length];
        v[node] = true;
        Deque<Integer> q = new LinkedList<>();
        q.add(node);
        while (q.peek() != null) {
            result.add(q.peekLast());
            boolean[] nodes = g[q.pollLast()];
            for (int i = 0; i < nodes.length; i++) {
                if (nodes[i] && !v[i]) {
                    q.addLast(i);
                    v[i] = true;
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        GraphMatrix g = new GraphMatrix(10);
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
        g = new GraphMatrix(10);

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
