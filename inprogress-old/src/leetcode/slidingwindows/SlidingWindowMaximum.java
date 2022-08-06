package leetcode.slidingwindows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Given an array and an integer K, find the maximum for each and every contiguous subarray of size k.
 * 
Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3 
Output: 3 3 4 5 5 5 6
Explanation: 
Maximum of 1, 2, 3 is 3
Maximum of 2, 3, 1 is 3
Maximum of 3, 1, 4 is 4
Maximum of 1, 4, 5 is 5
Maximum of 4, 5, 2 is 5 
Maximum of 5, 2, 3 is 5
Maximum of 2, 3, 6 is 6

Input: arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}, K = 4 
Output: 10 10 10 15 15 90 90
Explanation:
Maximum of first 4 elements is 10, similarly for next 4 
elements (i.e from index 1 to 4) is 10, So the sequence 
generated is 10 10 10 15 15 90 90
 */
public class SlidingWindowMaximum {
	// 3, 2, 1, 1, 3, 4, 5, 2, 3, 6
	// Deque : 3, 2, 1
	private static List<Integer> findMaxInK_Window(int[] arr, int k) {
		List<Integer> result = new LinkedList<>();

		Deque<Integer> deque = new LinkedList<>();
		int i = 0;
		for (; i < k; i++) {
			while (!deque.isEmpty() && arr[i] >= arr[deque.getLast()])
				deque.removeLast();
			deque.addLast(i);
		}

		for (; i < arr.length; i++) {
			result.add(arr[deque.getFirst()]);
			while (!deque.isEmpty() && deque.getFirst() <= i - k)
				deque.removeFirst();

			while (!deque.isEmpty() && arr[deque.getLast()] <= arr[i])
				deque.removeLast();

			deque.addLast(i);
		}

		result.add(arr[deque.getFirst()]);
		return result;
	}

	private static List<Integer> findMaxInK_WindowPriorityQueue(int[] arr, int k) {
		ArrayList<Integer> result = new ArrayList<>();

		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < k - 1; i++)
			queue.add(arr[i]);

		for (int i = 0; i <= arr.length - k; i++) {
			queue.add(arr[i + k - 1]);
			result.add(queue.peek());
			queue.remove(arr[i]);
		}
		return result;
	}

	private static List<Integer> findMaxInK_WindowIterative(int[] arr, int k) {
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i <= arr.length - k; i++) {
			int max = arr[i];
			for (int j = i + 1; j < i + k; j++)
				if (arr[j] > max)
					max = arr[j];
			result.add(max);
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(findMaxInK_WindowIterative(new int[] { 1, 2, 3, 1, 4, 5, 2, 3, 6 }, 3));
		System.out.println(findMaxInK_WindowIterative(new int[] { 8, 5, 10, 7, 9, 4, 15, 12, 90, 13 }, 4));
		System.out.println(findMaxInK_WindowPriorityQueue(new int[] { 1, 2, 3, 1, 4, 5, 2, 3, 6 }, 3));
		System.out.println(findMaxInK_WindowPriorityQueue(new int[] { 8, 5, 10, 7, 9, 4, 15, 12, 90, 13 }, 4));
		System.out.println(findMaxInK_Window(new int[] { 1, 2, 3, 1, 4, 5, 2, 3, 6 }, 3));
		System.out.println(findMaxInK_Window(new int[] { 8, 5, 10, 7, 9, 4, 15, 12, 90, 13 }, 4));
	}

}
