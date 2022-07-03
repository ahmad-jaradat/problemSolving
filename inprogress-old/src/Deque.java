import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node<Item> head;
    private Node<Item> tail;
    private int size = 0;

    public Deque() {
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        if (item == null)
            throw new IllegalArgumentException();
        size++;

        Node<Item> newNode = new Node<>();
        newNode.nextNode = head;
        newNode.value = item;

        if (head != null)
            head.preNode = newNode;

        head = newNode;

        if (tail == null)
            tail = head;

    }


    public void addLast(Item item) {
        if (item == null)
            throw new IllegalArgumentException();
        size++;

        Node<Item> newNode = new Node<>();
        newNode.preNode = tail;
        newNode.value = item;

        if (tail != null)
            tail.nextNode = newNode;

        tail = newNode;
        if (head == null)
            head = tail;

    }


    public Item removeFirst() {
        if(head == null)
            throw new NoSuchElementException();
        Item result = head.value;
        if (head == tail)
            head = tail = null;
        else
            head = head.nextNode;


        size--;
        return result;
    }


    public Item removeLast() {
        if(tail == null)
            throw new NoSuchElementException();
        Item result = tail.value;
        if (head == tail)
            head = tail = null;
        else
            tail = tail.preNode;
        size--;
        return result;
    }

    public Iterator<Item> iterator() {

        return new Iterator<Item>() {
            @Override
            public boolean hasNext() {
                return !isEmpty();
            }

            @Override
            public Item next() {
                return removeFirst();
            }
        };
    }


    public static void main(String[] args) {
        Deque<Integer> que = new Deque<>();
        System.out.println(que.isEmpty());
        que.addLast(1);
        System.out.println(que.isEmpty());
        System.out.println(que.removeLast());
        System.out.println(que.isEmpty());
        que.addLast(1);
        System.out.println(que.isEmpty());
        System.out.println(que.removeFirst());
        System.out.println(que.isEmpty());
        que.addFirst(1);
        System.out.println(que.isEmpty());
        System.out.println(que.removeLast());
        System.out.println(que.isEmpty());
        que.addFirst(1);
        System.out.println(que.isEmpty());
        System.out.println(que.removeFirst());
        System.out.println(que.isEmpty());
        que.addLast(2);
        que.addFirst(1);
        System.out.println(que.isEmpty());
        System.out.println(que.removeFirst());
        System.out.println(que.isEmpty());
        System.out.println(que.removeFirst());

    }

    private static class Node<Item> {
        public Node nextNode;
        public Node preNode;
        public Item value;
    }
}
