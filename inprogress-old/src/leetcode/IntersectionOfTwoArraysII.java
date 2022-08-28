package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*

Given two integer arrays nums1 and nums2, return an array of their intersection. 
Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

Example 1:

	Input: nums1 = [1,2,2,1], nums2 = [2,2]
	Output: [2,2]

Example 2:

	Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
	Output: [4,9]
	Explanation: [9,4] is also accepted.

 */
public class IntersectionOfTwoArraysII {

	private static int[] intersect(int[] nums1, int[] nums2) {
		final Map<Integer, Integer> n1Count = new HashMap<>();
		final ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < nums1.length; i++)
			n1Count.put(nums1[i], n1Count.getOrDefault(nums1[i], 0) + 1);
		for (int i = 0; i < nums2.length; i++) {
			if (n1Count.getOrDefault(nums2[i], 0) > 0) {
				result.add(nums2[i]);
				n1Count.put(nums2[i], n1Count.get(nums2[i]) - 1);
			}
		}
		int[] r = new int[result.size()];
		int rI = 0;
		for (Integer i : result)
			r[rI++] = i;
		return r;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(intersect(new int[] { 1, 2, 2, 1 }, new int[] {2, 2}))); // [2, 2]
		System.out.println(Arrays.toString(intersect(new int[] { 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 }))); // [4, 9]
	}
}