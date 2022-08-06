package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

Example 1:

Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10

Example 2:

Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101

Constraints:

    0 <= n <= 105

 */
public class CountsBits {

	private static int[] countBits2(int n) {
		int[] f = new int[n + 1];
		for (int i = 1; i <= n; i++)
			f[i] = f[i >> 1] + (i & 1);
		return f;
	}

	private static int[] countBits(int n) {
		int[] result = new int[n + 1];
		for (int i = n; i >= 0; i--)
			result[i] = count(i, 1);
		return result;
	}

	private static Map<Integer, Integer> cache = new HashMap<>();

	private static int count(int n, int bit) {
		if (n <= 0)
			return 0;
		if (cache.get(n) != null)
			return cache.get(n);
		int result = 0;
		if ((bit & n) > 0) {
			result = 1;
			result += count(n ^ bit, bit * 2);
		} else {
			result += count(n, bit * 2);
		}

		cache.put(n, result);

		return result;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(countBits(2)));
		System.out.println(Arrays.toString(countBits(5)));
		System.out.println(Arrays.toString(countBits2(2)));
		System.out.println(Arrays.toString(countBits2(5)));
	}
}
