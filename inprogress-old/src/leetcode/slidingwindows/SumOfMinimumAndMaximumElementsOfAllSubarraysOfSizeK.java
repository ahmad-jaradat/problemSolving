package leetcode.slidingwindows;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * Given an array of both positive and negative integers, the task is to compute sum of minimum and maximum elements of all sub-array of size k.


Input : arr[] = {2, 5, -1, 7, -3, -1, -2}  
        K = 4
Output : 18
Explanation : Subarrays of size 4 are : 
     {2, 5, -1, 7},   min + max = -1 + 7 = 6
     {5, -1, 7, -3},  min + max = -3 + 7 = 4      
     {-1, 7, -3, -1}, min + max = -3 + 7 = 4
     {7, -3, -1, -2}, min + max = -3 + 7 = 4
        
Sum of all min & max = 6 + 4 + 4 + 4 = 18 
 */
public class SumOfMinimumAndMaximumElementsOfAllSubarraysOfSizeK {

	private static List<Integer> sumMaxMinInKWindow2(int[] arr, int k) {
		List<Integer> result = new LinkedList<>();

		Deque<Integer> max = new LinkedList<>();
		Deque<Integer> min = new LinkedList<>();

		int i = 0;

		for (; i < k; i++) {
			while (!max.isEmpty() && arr[i] >= arr[max.getLast()])
				max.removeLast();
			while (!min.isEmpty() && arr[i] <= arr[min.getLast()])
				min.removeLast();

			max.addLast(i);
			min.addLast(i);
		}

		for (; i < arr.length; i++) {
			result.add(arr[max.getFirst()] + arr[min.getFirst()]);

			while (!max.isEmpty() && max.getFirst() <= i - k)
				max.removeFirst();
			while (!min.isEmpty() && min.getFirst() <= i - k)
				min.removeFirst();

			while (!max.isEmpty() && arr[i] >= arr[max.getLast()])
				max.removeLast();
			while (!min.isEmpty() && arr[i] <= arr[min.getLast()])
				min.removeLast();

			min.addLast(i);
			max.addLast(i);
		}
		result.add(arr[max.getFirst()] + arr[min.getFirst()]);
		return result;
	}

	private static List<Integer> sumMaxMinInKWindow(int[] arr, int k) {
		List<Integer> result = new LinkedList<>();

		Deque<Integer> max = new LinkedList<>();
		Deque<Integer> min = new LinkedList<>();

		int i = 0;

		for (; i < k; i++) {
			while (!max.isEmpty() && arr[max.getLast()] <= arr[i])
				max.removeLast();
			while (!min.isEmpty() && arr[min.getLast()] >= arr[i])
				min.removeLast();
			min.addLast(i);
			max.addLast(i);
		}

		for (; i < arr.length; i++) {

			result.add(arr[max.getFirst()] + arr[min.getFirst()]);
			while (!max.isEmpty() && max.getFirst() <= i - k)
				max.removeFirst();
			while (!min.isEmpty() && min.getFirst() <= i - k)
				min.removeFirst();

			while (!max.isEmpty() && arr[max.getLast()] <= arr[i])
				max.removeLast();
			while (!min.isEmpty() && arr[min.getLast()] >= arr[i])
				min.removeLast();

			max.addLast(i);
			min.addLast(i);
		}

		result.add(arr[max.getFirst()] + arr[min.getFirst()]);
		return result;
	}

	public static void main(String[] args) {
		System.out.println(sumMaxMinInKWindow(new int[] { 2, 5, -1, 7, -3, -1, -2 }, 4));
		System.out.println(sumMaxMinInKWindow2(new int[] { 2, 5, -1, 7, -3, -1, -2 }, 4));
	}
}
