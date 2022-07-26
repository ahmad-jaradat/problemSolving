package leetcode;

import java.util.LinkedList;

/*
 * Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

 

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]

Example 2:

Input: nums = [1,1]
Output: [2]

 

Constraints:

    n == nums.length
    1 <= n <= 105
    1 <= nums[i] <= n

 

Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

 */

import java.util.List;

public class FindAllNumbersDisappearedInAnArray {

	private static List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> result = new LinkedList<>();
		int ptr = 0;
		int tmp;

		for (int i = 0; i < nums.length; i++) {
			ptr = nums[i];
			while (ptr <= nums.length && ptr != nums[ptr - 1]) {
				tmp = nums[ptr - 1];
				nums[ptr - 1] = ptr;
				ptr = tmp;
			}
		}
		for (int i = 0; i < nums.length; i++)
			if (nums[i] != i + 1)
				result.add(i + 1);
		return result;
	}

	public static void main(String[] args) {
		System.out.println(findDisappearedNumbers(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }));
		System.out.println(findDisappearedNumbers(new int[] { 1, 1 }));
	}
}
