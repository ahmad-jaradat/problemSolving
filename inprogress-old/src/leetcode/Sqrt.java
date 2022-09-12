package leetcode;

/*

Given a non-negative integer x, compute and return the square root of x.

Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.

Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.

 

Example 1:

	Input: x = 4
	Output: 2

Example 2:

	Input: x = 8
	Output: 2
	Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.

 

Constraints:

    0 <= x <= 231 - 1


 */
public class Sqrt {

	public static int mySqrt(int x) {
		if (x == 1)
			return 1;
		int l = 0;
		int r = 1024 * 64;
		int m = l + (r - l) / 2;
		while (l <= r) {
			m = l + (r - l) / 2;
			int msqr = m * m;
			if (msqr == x)
				break;
			if (msqr < x && (m + 1) * (m + 1) > x)
				break;
			if (msqr > x)
				r = m - 1;
			else
				l = m + 1;
		}
		return m;
	}

	public static void main(String[] args) {
		System.out.println(mySqrt(0));// 0
		System.out.println(mySqrt(1));// 1
		System.out.println(mySqrt(3));// 1
		System.out.println(mySqrt(4));// 2
		System.out.println(mySqrt(6));// 2
		System.out.println(mySqrt(8));// 2
		System.out.println(mySqrt(10));// 3
		System.out.println(mySqrt(2147395599));// 46339
	}
}
