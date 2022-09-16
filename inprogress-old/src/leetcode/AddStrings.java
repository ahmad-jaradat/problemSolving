package leetcode;

/*

Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.

You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.

 

Example 1:

Input: num1 = "11", num2 = "123"
Output: "134"

Example 2:

Input: num1 = "456", num2 = "77"
Output: "533"

Example 3:

Input: num1 = "0", num2 = "0"
Output: "0"

 
 
 */
public class AddStrings {

	private static String addStrings(String num1, String num2) {
		num1 = '0' + num1;
		num2 = '0' + num2;
		int i = num1.length() - 1;
		int j = num2.length() - 1;
		String r = "";
		boolean carry = false;
		while (i >= 0 || j >= 0) {
			int sum = (carry ? 1 : 0) + num1.charAt(i) - '0' + num2.charAt(j) - '0';
			if (sum > 9) {
				carry = true;
				sum -= 10;
			} else {
				carry = false;
			}
			r = sum + r;
			if (i > 0)
				i--;
			if (j > 0)
				j--;
			if (i == 0 && j == 0)
				return (carry ? "1" : "") + r;
		}
		return r;
	}

	public static void main(String[] args) {
		System.out.println(addStrings("11", "123")); // 134
		System.out.println(addStrings("456", "77")); // 533
		System.out.println(addStrings("9", "1")); // 0
		System.out.println(addStrings("0", "0")); // 0
	}
}
