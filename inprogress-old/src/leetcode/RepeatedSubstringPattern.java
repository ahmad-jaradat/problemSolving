package leetcode;

/*
 Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.

 

Example 1:
	
	Input: s = "abab"
	Output: true
	Explanation: It is the substring "ab" twice.

Example 2:

	Input: s = "aba"
	Output: false

Example 3:

	Input: s = "abcabcabcabc"
	Output: true
	Explanation: It is the substring "abc" four times or the substring "abcabc" twice.

 
 */
public class RepeatedSubstringPattern {

	private static boolean repeatedSubstringPattern(String s) {
		for (int i = 1; i <= s.length() / 2; i++) {
			if (re(s, 0, i)) {
				int start = i;
				int end = start + i;
				boolean falied = false;
				for (; end < s.length(); end += i, start += i) {
					if (!re(s, start, end)) {
						falied = true;
						break;
					}
				}
				if (!falied && end == s.length())
					return true;
			}
		}
		return false;
	}

	private static boolean re(String s, int start, int end) {
		for (int j = 0; j < end - start; j++) {
			if (j + end >= s.length() || s.charAt(start + j) != s.charAt(end + j))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(repeatedSubstringPattern("abab"));// true
		System.out.println(repeatedSubstringPattern("aba"));// false
		System.out.println(repeatedSubstringPattern("abcabcabcabc"));// true
		System.out.println(repeatedSubstringPattern("abcafabcaf"));// true
		System.out.println(repeatedSubstringPattern("abcafabcag"));// false
		System.out.println(repeatedSubstringPattern("abcafabcafg"));// false
		System.out.println(repeatedSubstringPattern("ababba"));// false
		System.out.println(repeatedSubstringPattern("ababab"));// true
		System.out.println(repeatedSubstringPattern("ababababab"));// true
	}
}
