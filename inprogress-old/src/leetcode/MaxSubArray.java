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



Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

 */
public class MaxSubArray {

    private static int maxSubArray(int[] arr) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int maxElements = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (arr[i] > maxElements)
                maxElements = arr[i];
            if (sum < 0)
                sum = 0;
            else if (sum > max)
                max = sum;
        }
        return max == Integer.MIN_VALUE ? maxElements : max;
    }



    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})); // 6
        System.out.println(maxSubArray(new int[]{1})); // 1
        System.out.println(maxSubArray(new int[]{5, 4, -1, 7, 8})); // 23
        System.out.println(maxSubArray(new int[]{-1, -2, -3, -4})); // -1
    }
}
