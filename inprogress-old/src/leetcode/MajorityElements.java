package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.



Example 1:

Input: nums = [3,2,3]
Output: 3

Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2



Constraints:

    n == nums.length
    1 <= n <= 5 * 104
    -109 <= nums[i] <= 109


Follow-up: Could you solve the problem in linear time and in O(1) space?


// Solution use Boyer Moore majority vote algorithm
 */
public class MajorityElements {

    private static int majorityElement(int[] nums) {
        int major = nums[0];
        int vote = 0;
        for (int i = 0; i < nums.length; i++) {
            if (major != nums[i]) {
                vote--;
            } else {
                vote++;
            }
            if (vote == 0) {
                major = nums[i];
                vote = 1;
            }
        }
        return major;
    }

    private static int majorityElement2(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (count.containsKey(nums[i]) && count.getOrDefault(nums[i], 0) == ((nums.length / 2)))
                return nums[i];
            else
                count.put(nums[i], (count.getOrDefault(nums[i], 0) + 1));
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3}));
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
        System.out.println(majorityElement2(new int[]{2, 3, 3}));
        System.out.println(majorityElement2(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}
