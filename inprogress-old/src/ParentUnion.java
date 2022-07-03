public class ParentUnion {

    private final int[] numbers;

    public ParentUnion(int size) {
        numbers = new int[size + 1];
        for (int i = 1; i <= size; i++)
            numbers[i] = i;
    }

    public void union(int a, int b) {
        a = root(a);
        b = root(b);
        if (a < b) {
            numbers[a] = numbers[b];
        } else {
            numbers[b] = numbers[a];
        }
    }

    public boolean find(int a, int b) {
        a = root(a);
        b = root(b);
        return numbers[a] == numbers[b];
    }

    private int root(int i) {
        while (i != numbers[i]) {
            numbers[i] = numbers[numbers[i]];
            i = numbers[i];
        }
        return i;
    }

    public void printStorage() {
    }
}
