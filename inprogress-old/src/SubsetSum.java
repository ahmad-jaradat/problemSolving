/*
    Given a set of non-negative integers, and a value sum, determine if there is a subset of
    the given set with sum equal to given sum.
 */

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class SubsetSum {
    static AtomicInteger count = new AtomicInteger(1);

    static boolean sol_Rec(int[] arr, int number, int i) {
        count.incrementAndGet();
        if (i >= arr.length || number < 0)
            return false;
        if (number - arr[i] == 0)
            return true;
        return sol_Rec(arr, number, i + 1) || sol_Rec(arr, number - arr[i], i + 1);
    }

    static int[][] result;

    static boolean sol_topDown(int[] arr, int number, int i) {
        count.incrementAndGet();
        if (result[number][i] != -1) {
            return result[number][i] == 1;
        }
        if (i >= arr.length || number < 0)
            return false;
        if (number - arr[i] == 0)
            return true;
        boolean b = sol_topDown(arr, number, i + 1) || sol_topDown(arr, number - arr[i], i + 1);
        result[number][i] = b ? 1 : 0;
        return b;
    }

    static boolean sol_bottonUp(int[] arr, int number) {
        boolean[][] dp = new boolean[arr.length + 1][number + 1];

        for (int nu = 0; nu < number; nu++)
            dp[0][nu] = true;

        for (int i = 0; i < arr.length; i++)
            dp[i][0] = false;

        for (int setEl = 1; setEl < dp.length; setEl++)
            for (int num = 1; num < dp[0].length; num++) {
                count.incrementAndGet();
                dp[setEl][num] = dp[setEl - 1][num];
                if (number > arr[setEl - 1]) {
                    dp[setEl][num] = dp[setEl][num] || dp[setEl - 1][num - arr[setEl - 1]];
                }
            }
        return dp[arr.length][number];
    }

    static boolean sol_bottobUp_orderSum(int[] elements, int sum) {
        count.set(0);
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int i = 0; i < elements.length; i++)
            for (int j = sum; j >= elements[i]; j--) {
                count.incrementAndGet();
                if (dp[j - elements[i]])
                    dp[j] = true;
            }
        System.out.println(Arrays.toString(dp));
        return dp[sum];
    }

    public static void main(String[] args) {
        System.out.println(sol_Rec(new int[]{1, 2, 3}, 5, 0));
        System.out.println(count.getAndSet(0));
        System.out.println(sol_Rec(new int[]{2, 9, 12, 11, 1, 3, 7, 4}, 100, 0));
        System.out.println(count.getAndSet(0));
        System.out.println(sol_Rec(new int[]{2}, 2, 0));
        System.out.println(count.getAndSet(0));
        result = new int[100][100];
        for (int i = 0; i < result.length; i++)
            Arrays.fill(result[i], -1);
        System.out.println(sol_topDown(new int[]{1, 2, 3}, 5, 0));
        System.out.println(count.getAndSet(0));
        result = new int[101][101];
        for (int i = 0; i < result.length; i++)
            Arrays.fill(result[i], -1);
        System.out.println(sol_topDown(new int[]{2, 9, 12, 11, 1, 3, 7, 4}, 100, 0));
        System.out.println(count.getAndSet(0));
        result = new int[101][101];
        for (int i = 0; i < result.length; i++)
            Arrays.fill(result[i], -1);
        System.out.println(sol_topDown(new int[]{2}, 2, 0));
        System.out.println(count.getAndSet(0));

        System.out.println(sol_bottonUp(new int[]{1, 2, 3}, 5));
        System.out.println(count.getAndSet(0));
        System.out.println(sol_bottonUp(new int[]{2, 9, 12, 11, 1, 3, 7, 4}, 100));
        System.out.println(count.getAndSet(0));
        System.out.println(sol_bottonUp(new int[]{2}, 2));
        System.out.println(count.getAndSet(0));


        System.out.println(sol_bottobUp_orderSum(new int[]{1, 2, 3}, 5));
        System.out.println(count.getAndSet(0));
        System.out.println(sol_bottobUp_orderSum(new int[]{2, 9, 12, 11, 1, 3, 7, 4}, 100));
        System.out.println(count.getAndSet(0));
        System.out.println(sol_bottobUp_orderSum(new int[]{2}, 2));
        System.out.println(count.getAndSet(0));
    }
}
