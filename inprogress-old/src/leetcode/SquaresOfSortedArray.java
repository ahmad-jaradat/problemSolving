package leetcode;

import java.net.Socket;
import java.util.Arrays;

/*
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

 

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].

Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]

 

Constraints:

    1 <= nums.length <= 104
    -104 <= nums[i] <= 104
    nums is sorted in non-decreasing order.

 
Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?
 */
public class SquaresOfSortedArray {

	private static int[] sortedSquares(int[] nums) {
		int minIndex = -1;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			nums[i] = nums[i] * nums[i];
			if (nums[i] < min) {
				min = nums[i];
				minIndex = i;
			}
		}

		int[] ans = new int[nums.length];
		int rI = 0;
		int l = minIndex;
		int r = l == nums.length - 1 ? l-- : minIndex + 1;
		while ((l >= 0 || r < nums.length)) {
			if (r == nums.length) {
				ans[rI++] = nums[l--];
			} else if (l < 0) {
				ans[rI++] = nums[r++];
			} else if (Math.abs(nums[l]) > Math.abs(nums[r])) {
				ans[rI++] = nums[r++];
			} else {
				ans[rI++] = nums[l--];
			}

		}
		return ans;
	}

	public final static void main(String[] args) {
		System.out.println(Arrays.toString(sortedSquares(new int[] { -4, -1, 0, 3, 10 }))); // 0,1,9,16,100
		System.out.println(Arrays.toString(sortedSquares(new int[] { -7, -3, 2, 3, 11 }))); // 4,9,9,49,121
		System.out.println(Arrays.toString(sortedSquares(new int[] { -9, -5, -2, -1 }))); // 1,4,25,81
		System.out.println(Arrays.toString(sortedSquares(new int[] { 0, 5, 6, 9, 10 }))); // 0,25,36,81,100
	}

}
