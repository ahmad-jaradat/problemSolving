package leetcode;

/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true

Example 2:

Input: s = "rat", t = "car"
Output: false

 */
public class ValidAnagram {

	private static boolean isAnagram(String s, String t) {
		short[] count = new short['z' - 'a' + 1];
		for (int i = 0; i < s.length(); i++)
			count[s.charAt(i) - 'a']++;
		for (int i = 0; i < t.length(); i++)
			count[t.charAt(i) - 'a']--;
		for (int i = 0; i < count.length; i++)
			if (count[i] != 0)
				return false;
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isAnagram("anagram", "nagaram"));
		System.out.println(isAnagram("rat", "car"));
	}
}
