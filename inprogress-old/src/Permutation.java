import edu.princeton.cs.algs4.StdIn;

public class Permutation {
    public static void main(String[] args) {
        Integer itemCount = Integer.valueOf(args[0]);
        RandomizedQueue<String> qu = new RandomizedQueue<>();
        for (int i = 0; i < itemCount; i++) {
            qu.enqueue(StdIn.readString());
        }
        while (!qu.isEmpty())
            System.out.println(qu.sample());
    }
}
