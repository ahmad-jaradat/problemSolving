package leetcode;

import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;

/*
Given an integer array nums, handle multiple queries of the following types:

    Update the value of an element in nums.
    Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.

Implement the NumArray class:

    NumArray(int[] nums) Initializes the object with the integer array nums.
    void update(int index, int val) Updates the value of nums[index] to be val.
    int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).

 

Example 1:

Input
["NumArray", "sumRange", "update", "sumRange"]
[[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
Output
[null, 9, null, 8]

Explanation
NumArray numArray = new NumArray([1, 3, 5]);
numArray.sumRange(0, 2); // return 1 + 3 + 5 = 9
numArray.update(1, 2);   // nums = [1, 2, 5]
numArray.sumRange(0, 2); // return 1 + 2 + 5 = 8

 

Constraints:

    1 <= nums.length <= 3 * 104
    -100 <= nums[i] <= 100
    0 <= index < nums.length
    -100 <= val <= 100
    0 <= left <= right < nums.length
    At most 3 * 104 calls will be made to update and sumRange.


 */
public class RangeSumQueryMutable {

	private static class NumArray {

		private int[] segment;
		private int[] arr;

		public NumArray(int[] nums) {
			arr = nums;
			int segmentSize = (int) Math.pow(2, (int) Math.ceil(Math.log(nums.length) / Math.log(2)) + 1) - 1;
			segment = new int[segmentSize];
			build(0, arr.length - 1, 0, nums);
		}

		private int build(int s, int e, int sI, int[] arr) {
			if (s == e) {
				segment[sI] = arr[s];
				return arr[s];
			}
			int m = s + (e - s) / 2;
			segment[sI] = build(s, m, sI * 2 + 1, arr) + build(m + 1, e, sI * 2 + 2, arr);
			return segment[sI];
		}

		public void update(int index, int val) {
			int diff = val - arr[index];
			arr[index] = val;
			update(index, 0, arr.length - 1, diff, 0);
		}

		private void update(int index, int s, int e, int diff, int sI) {
			if (index < s || index > e)
				return;
			segment[sI] += diff;
			if (s != e) {
				int m = (s + e) / 2;
				if (m >= index) {
					update(index, s, m, diff, sI * 2 + 1);
				} else {
					update(index, m + 1, e, diff, sI * 2 + 2);
				}
			}
		}

		public int sumRange(int left, int right) {
			return sumRange(0, arr.length - 1, left, right, 0);
		}

		private int sumRange(int s, int e, int qs, int qe, int sI) {
			if (s > qe || e < qs)
				return 0;
			if (s >= qs && e <= qe)
				return segment[sI];
			int m = (e + s) / 2;
			return sumRange(s, m, qs, qe, sI * 2 + 1) + sumRange(m + 1, e, qs, qe, sI * 2 + 2);
		}
	}

	public static void main(String[] args) {
		NumArray numArray = new NumArray(new int[] { 1, 3, 5 });
		System.out.println(numArray.sumRange(0, 2)); // 9
		numArray.update(1, 2); // nums = [1, 2, 5]
		System.out.println(numArray.sumRange(0, 2)); // 8
		System.out.println(numArray.sumRange(0, 0)); // 1
		/*
		 * ["NumArray","update","update","update","sumRange","update","sumRange",
		 * "update","sumRange","sumRange","update"]
		 * [[[7,2,7,2,0]],[4,6],[0,2],[0,9],[4,4],[3,8],[0,4],[4,1],[0,3],[0,4],[0,4]]
		 * [null,null,null,null,6,null,32,null,26,27,null]
		 * 
		 */
		System.out.println("abcdefgh");
		numArray = new NumArray(new int[] { 7, 2, 7, 2, 0 });
		numArray.update(4, 6);
		numArray.update(0, 2);
		numArray.update(0, 9);
		System.out.println(numArray.sumRange(4, 4));
		numArray.update(3, 8);
		System.out.println(numArray.sumRange(0, 4));
		numArray.update(4, 1);
		System.out.println(numArray.sumRange(0, 3));
		System.out.println(numArray.sumRange(0, 4));
		numArray.update(0, 4);
	}
}
