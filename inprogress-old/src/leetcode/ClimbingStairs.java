package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
* Climbing Stairs
Easy

You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?



Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step



Constraints:

    1 <= n <= 45


 */
public class ClimbingStairs {

    private static Map<Integer, Integer> steps = new HashMap<>();

    private static int climbStairs(int n) {
        if (n == 0)
            return 1;
        else if (n < 0)
            return 0;

        if (steps.containsKey(n))
            return steps.get(n);

        int result = climbStairs(n - 1) + climbStairs(n - 2);
        steps.put(n, result);
        return result;
    }

    private static int climbStairsBottonUp(int n) {
        int[] table = new int[n + 1];
        table[0] = 1;
        table[1] = 1;
        for (int i = 1; i < n; i++)
            table[1 + i] = table[i - 1] + table[i];
        return table[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(2));
        steps = new HashMap<>();
        System.out.println(climbStairs(3));
        System.out.println(climbStairsBottonUp(2));
        System.out.println(climbStairsBottonUp(3));
    }
}
