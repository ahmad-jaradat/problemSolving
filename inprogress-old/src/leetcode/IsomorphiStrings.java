package leetcode;

/*

Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

 

Example 1:

	Input: s = "egg", t = "add"
	Output: true

Example 2:

	Input: s = "foo", t = "bar"
	Output: false

Example 3:

	Input: s = "paper", t = "title"
	Output: true

 

Constraints:

    1 <= s.length <= 5 * 104
    t.length == s.length
    s and t consist of any valid ascii character.


 */
public class IsomorphiStrings {

	private static boolean isIsomorphic(String s, String t) {
		Character[] st = new Character[255];
		boolean[] tE = new boolean[255];

		if (s.length() != t.length())
			return false;

		char[] schar = s.toCharArray();
		char[] tchar = t.toCharArray();

		for (int i = 0; i < s.length(); i++) {
			if (st[schar[i]] != null) {
				if (st[schar[i]] != tchar[i])
					return false;
			} else {
				if (tE[tchar[i]])
					return false;
				st[schar[i]] = tchar[i];
			}
			tE[tchar[i]] = true;
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(isIsomorphic("egg", "add"));// true
		System.out.println(isIsomorphic("foo", "bar"));// false
		System.out.println(isIsomorphic("paper", "title"));// true
		System.out.println(isIsomorphic("badc", "baba"));// false
		System.out.println(isIsomorphic("dad0", "bab1"));// true
		System.out.println(isIsomorphic("dad0", "bab1"));// true
	}
}
