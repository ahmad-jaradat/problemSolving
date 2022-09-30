package leetcode;

/*
 Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

Example 2:

Input: nums = [1]
Output: 1

Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23

 

Constraints:

    1 <= nums.length <= 105
    -104 <= nums[i] <= 104

 */
public class MaximumSubarray {

	private static int maxSubArray(int[] nums) {
		int max = nums[0];
		int currentMax = 0;
		for (int n : nums) {
			currentMax = Math.max(currentMax + n, n);
			max = Math.max(max, currentMax);
		}
		return max;

	}

	private static int maxSubArray2(int[] nums) {
		int max = Integer.MIN_VALUE;
		int currentSum = 0;
		for (Integer a : nums) {
			currentSum += a;
			if (currentSum > max) {
				max = currentSum;
			}
			if (currentSum <= 0) {
				currentSum = 0;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 })); // 6
		System.out.println(maxSubArray(new int[] { 1 })); // 1
		System.out.println(maxSubArray(new int[] { 5, 4, -1, 7, 8 })); // 23
		System.out.println(maxSubArray(new int[] { -5, -4, -1, -7, -8 })); // -1
	}
}
