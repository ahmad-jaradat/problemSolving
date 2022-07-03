import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private final List<Item> items = new ArrayList<>();

    public RandomizedQueue() {

    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int size() {
        return items.size();
    }

    public void enqueue(Item item) {
        if (item == null)
            throw new IllegalArgumentException();
        items.add(item);
    }

    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException();
        return items.remove(StdRandom.uniform(0, size()));
    }

    public Item sample() {
        return dequeue();
    }


    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            @Override
            public boolean hasNext() {
                return !isEmpty();
            }

            @Override
            public Item next() {
                return dequeue();
            }
        };
    }


    public static void main(String[] args) {
        RandomizedQueue<Integer> qu = new RandomizedQueue();
        qu.enqueue(1);
        qu.enqueue(2);
        qu.enqueue(3);
        qu.enqueue(4);
        qu.enqueue(5);
        qu.enqueue(6);
        qu.enqueue(7);
        qu.enqueue(8);
        while(!qu.isEmpty())
            System.out.println(qu.sample());
    }

}
