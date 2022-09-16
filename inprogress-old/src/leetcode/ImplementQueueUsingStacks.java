package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/*

Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

Implement the MyQueue class:

    void push(int x) Pushes element x to the back of the queue.
    int pop() Removes the element from the front of the queue and returns it.
    int peek() Returns the element at the front of the queue.
    boolean empty() Returns true if the queue is empty, false otherwise.

Notes:

    You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
    Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.

 

Example 1:

Input
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 1, 1, false]

Explanation
MyQueue myQueue = new MyQueue();
myQueue.push(1); // queue is: [1]
myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
myQueue.peek(); // return 1
myQueue.pop(); // return 1, queue is [2]
myQueue.empty(); // return false

 */
public class ImplementQueueUsingStacks {

	private static class MyQueue {

		private Deque<Integer> stack1 = new LinkedList<>();
		private Deque<Integer> stack2 = new LinkedList<>();

		public MyQueue() {

		}

		public void push(int x) {
			stack1.addFirst(x);
		}

		public int pop() {
			if (stack2.isEmpty())
				moveToStack2();
			return stack2.removeFirst();
		}

		public int peek() {
			if (stack2.isEmpty())
				moveToStack2();
			return stack2.getFirst();
		}

		public boolean empty() {
			return stack1.isEmpty() && stack2.isEmpty();
		}

		private void moveToStack2() {
			while (!stack1.isEmpty())
				stack2.addFirst(stack1.removeFirst());
		}
	}

	public static void main(String[] args) {
		MyQueue myQueue = new MyQueue();
		myQueue.push(1); // queue is: [1]
		myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
		System.out.println(myQueue.peek()); // return 1
		System.out.println(myQueue.pop()); // return 1, queue is [2]
		System.out.println(myQueue.empty()); // return false
		System.out.println(myQueue.pop()); // 2
		System.out.println(myQueue.empty());// true
		myQueue.push(1); // queue is: [1]
		myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
		System.out.println(myQueue.peek()); // return 1
		System.out.println(myQueue.pop()); // return 1, queue is [2]
		System.out.println(myQueue.empty()); // return false
		System.out.println(myQueue.pop()); // 2
		System.out.println(myQueue.empty());// true
	}
}
