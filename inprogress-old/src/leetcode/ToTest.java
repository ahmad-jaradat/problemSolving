package leetcode;

import java.util.Arrays;

public class ToTest {
	private static int[] segment;
	private static int n;

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		n = nums.length;
		int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
		int max_size = 2 * (int) Math.pow(2, x) - 1;
		System.out.println(max_size);
		segment = new int[max_size];
		fillSegmentTree(nums, 0, nums.length - 1, 0);
		System.out.println(Arrays.toString(segment));
		System.out.println(getSum(0, n - 1));
		System.out.println(getSum(0, 8));

	}

	private static int getSum(int qs, int qe) {
		return getSum(0, n - 1, qs, qe, 0);
	}

	private static int getSum(int s, int e, int qs, int qe, int si) {
		if (s >= qs && e <= qe) {
			return segment[si];
		}
		if (e < qs || s > qe) {
			return 0;
		}
		int mid = s + ((e - s) / 2);
		return getSum(s, mid, qs, qe, si * 2 + 1) + getSum(mid + 1, e, qs, qe, si * 2 + 2);
	}

	private static int fillSegmentTree(int[] arr, int s, int e, int i) {
		if (s == e) {
			segment[i] = arr[s];
			return arr[s];
		}
		int m = (s + e) / 2;
		segment[i] = fillSegmentTree(arr, s, m, i * 2 + 1) + fillSegmentTree(arr, m + 1, e, i * 2 + 2);
		return segment[i];
	}

}
