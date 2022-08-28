package leetcode;

import java.util.Arrays;

/*
 * Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

 

Constraints:

    1 <= strs.length <= 200
    0 <= strs[i].length <= 200
    strs[i] consists of only lowercase English letters.


 */
public class LongestCommonPrefix {

	private static String longestCommonPrefix(String[] strs) {
		String result = "";
		int index = 0;
		for (int j = 0; j < strs[0].length(); j++) {
			for (int i = 1; i < strs.length; i++) {
				if (strs[i].length() <= j || (strs[i]).charAt(j) != strs[0].charAt(j))
					return result;
			}
			result += strs[0].charAt(j);
		}
		return result;
	}

	private static String lcPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";

		Arrays.sort(strs);
		String first = strs[0];
		String last = strs[strs.length - 1];
		int c = 0;
		while (c < first.length()) {
			if (first.charAt(c) == last.charAt(c))
				c++;
			else
				break;
		}
		return c == 0 ? "" : first.substring(0, c);
	}

	public static void main(String[] args) {
		System.out.println(longestCommonPrefix(new String[] { "flower", "flow", "flight" }));
		System.out.println(longestCommonPrefix(new String[] { "dog", "racecar", "car" }));
		System.out.println(longestCommonPrefix(new String[] { "ab", "a" }));
	}
}
