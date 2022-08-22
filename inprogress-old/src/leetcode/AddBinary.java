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
		String result = "";
		char[] aA = a.toCharArray();
		char[] bA = b.toCharArray();
		short carry = 0;
		int i = 0;
		short r = 0;
		while (i < aA.length || i < bA.length) {
			if (i < aA.length && i < bA.length) {
				r = (short) (aA[i] - '0' + bA[i] - '0' + carry);
			} else if (i < aA.length) {
				r = (short) (aA[i] - '0' + carry);
			} else {
				r = (short) (bA[i] - '0' + carry);
			}

			if (r == 0)
				result = '0' + result;
			else if (r == 1)
				result = '1' + result;
			else if (r == 2) {
				result = '0' + result;
				carry = 1;
			} else {
				result = '1' + result;
				carry = 1;
			}
			i++;
		}
		if (carry == 1)
			result = '1' + result;
		return result;
	}

	public static void main(String[] args) {
		System.out.println(addBinary("11", "1"));
		System.out.println(addBinary("1010", "1011"));
	}
}
