package leetcode;

/*

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.

 */
public class ValidPalindrome {

	private static boolean isPalindrome(String s) {
		char[] c = s.toCharArray();
		int l = 0;
		int r = s.length() - 1;
		while (l < r) {

			if (c[l] >= 'A' && c[l] <= 'Z')
				c[l] = (char) (c[l] | 0x20);
			if (c[r] >= 'A' && c[r] <= 'Z')
				c[r] = (char) (c[r] | 0x20);

			if (c[l] < '0' || (c[l] > '9' && c[l] < 'a') || c[l] > 'z') {
				l++;
				continue;
			}

			if (c[r] < '0' || (c[r] > '9' && c[r] < 'a') || c[r] > 'z') {
				r--;
				continue;
			}

			if (c[l] != c[r])
				return false;
			l++;
			r--;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama")); // true
		System.out.println(isPalindrome("race a car")); // false
	}
}
