package leetcode;

/*
Given two binary strings a and b, return their sum as a binary string.

Example 1:
	
	Input: a = "11", b = "1"
	Output: "100"

Example 2:

	Input: a = "1010", b = "1011"
	Output: "10101"

Constraints:

    1 <= a.length, b.length <= 104
    a and b consist only of '0' or '1' characters.
    Each string does not contain leading zeros except for the zero itself.


 */
public class AddBinary {

	private static String addBinary(String a, String b) {
		StringBuilder result = new StringBuilder();
		char[] aA = a.toCharArray();
		char[] bA = b.toCharArray();
		int carry = 0;
		int aI = aA.length - 1;
		int bI = bA.length - 1;

		while (aI >= 0 || bI >= 0) {
			int sum = carry;
			if (aI >= 0)
				sum += (aA[aI--] - '0');
			if (bI >= 0)
				sum += (bA[bI--] - '0');
			result.append((sum % 2));
			carry =  (sum / 2);
		}
		if (carry == 1)
			result.append(carry);
		return result.reverse().toString();
	}

	public static void main(String[] args) {
		System.out.println(addBinary("11", "1")); // 100
		System.out.println(addBinary("1010", "1011")); // 10101
	}
}
