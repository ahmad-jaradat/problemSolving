package leetcode;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/*
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

 

Example 1:

Input: s = "leetcode"
Output: 0

Example 2:

Input: s = "loveleetcode"
Output: 2

Example 3:

Input: s = "aabb"
Output: -1

 

Constraints:

    1 <= s.length <= 105
    s consists of only lowercase English letters.


 */
public class FirstUniqueChar {

	private static int firstUniqChar(String s) {
		short[] chrCount = new short['z' - 'a' + 1];
		char[] charArray = s.toCharArray();

		int uniqueIndex = s.length() - 1;
		chrCount[charArray[uniqueIndex] - 'a'] = 1;
		Deque<Integer> stack = new LinkedList<>();
		stack.addFirst(s.length() - 1);

		for (int i = s.length() - 2; i >= 0; i--) {

			if (chrCount[charArray[i] - 'a'] <= 0) {
				uniqueIndex = i;
				chrCount[charArray[i] - 'a'] = 1;
				stack.addFirst(i);
			} else if (uniqueIndex != -1 && charArray[uniqueIndex] == charArray[i]) {
				chrCount[charArray[i] - 'a'] = 2;
				uniqueIndex = -1;
				while (!stack.isEmpty()) {
					int lastIndex = stack.removeFirst();
					if (chrCount[charArray[lastIndex] - 'a'] <= 1) {
						uniqueIndex = lastIndex;
						stack.addFirst(uniqueIndex);
						break;
					}
				}
			} else {
				chrCount[charArray[i] - 'a'] = 2;
			}
		}
		return uniqueIndex;
	}

	private static int firstUniqChar2(String s) {
		Map<Character, Integer> map = new LinkedHashMap<>();
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			if (set.contains(s.charAt(i))) {
				if (map.get(s.charAt(i)) != null) {
					map.remove(s.charAt(i));
				}
			} else {
				map.put(s.charAt(i), i);
				set.add(s.charAt(i));
			}
		}
		return map.size() == 0 ? -1 : map.entrySet().iterator().next().getValue();
	}

	public static void main(String[] args) {
		System.out.println(firstUniqChar("leetcode")); // 0
		System.out.println(firstUniqChar("loveleetcode")); // 2
		System.out.println(firstUniqChar("aabb")); // -1
		System.out.println(firstUniqChar("a")); // 0
		System.out.println(firstUniqChar("cc")); // -1
		System.out.println(firstUniqChar("dddccdbba")); // 8

		System.out.println(firstUniqChar2("leetcode")); // 0
		System.out.println(firstUniqChar2("loveleetcode")); // 2
		System.out.println(firstUniqChar2("aabb")); // -1
		System.out.println(firstUniqChar2("a")); // 0
		System.out.println(firstUniqChar2("cc")); // -1
		System.out.println(firstUniqChar2("dddccdbba")); // 8
	}
}
