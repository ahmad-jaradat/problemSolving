package leetcode;

import java.util.HashSet;
import java.util.Set;

/*
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Example 1:

    Input: nums = [1,2,3,1]
    Output: true

Example 2:

    Input: nums = [1,2,3,4]
    Output: false

Example 3:

    Input: nums = [1,1,1,3,3,4,3,2,4,2]
    Output: true

 */
public class ContainsDuplicate {

    private static boolean containsDuplicate(int[] nums) {
        Set<Integer> dup =  new HashSet<>();
        for(int i =0;i<nums.length;i++)
            if(!dup.add(nums[i]))
                return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1,2,3,1}));
        System.out.println(containsDuplicate(new int[]{1,2,3}));
    }
}
