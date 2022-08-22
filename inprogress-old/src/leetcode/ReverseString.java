package leetcode;

/*

Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.

 

Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]

Example 2:

Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]



 */
public class ReverseString {

	private static void reverseString(char[] s) {
		for (int i = 0; i < (s.length - 1) / 2; i++) {
			char tmp = s[i];
			s[i] = s[s.length - 1 - i];
			s[s.length - i - 1] = tmp;
		}
	}

	public static void main(String[] args) {
		char[] s = "hello".toCharArray();
		reverseString(s);
		System.out.println(s);
		s = "Hannah".toCharArray();
		reverseString(s);
		System.out.println(s);
		s = new char[] { 'A', ' ', 'm', 'a', 'n', ',', ' ', 'a', ' ', 'p', 'l', 'a', 'n', ',', ' ', 'a', ' ', 'c', 'a',
				'n', 'a', 'l', ':', ' ', 'P', 'a', 'n', 'a', 'm', 'a' };
		reverseString(s);
		System.out.println(s);
	}
}
