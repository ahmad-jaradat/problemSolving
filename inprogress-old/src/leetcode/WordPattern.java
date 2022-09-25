package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.



Example 1:

Input: pattern = "abba", s = "dog cat cat dog"
Output: true

Example 2:

Input: pattern = "abba", s = "dog cat cat fish"
Output: false

Example 3:

Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false



Constraints:

    1 <= pattern.length <= 300
    pattern contains only lower-case English letters.
    1 <= s.length <= 3000
    s contains only lowercase English letters and spaces ' '.
    s does not contain any leading or trailing spaces.
    All the words in s are separated by a single space.


 */
public class WordPattern {
    private static boolean wordPattern(String pattern, String s) {
        String[] sParts = s.split(" ");
        if(sParts.length != pattern.length())
            return false;
        Map<Character, String> m = new HashMap<>();
        Map<String, Character> m2 = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String sPart = sParts[i];

            String w = m.get(ch);
            Character c = m2.get(sPart);

            if (w != null && c != null && w.equals(sPart) && c == ch)
                continue;
            else if (w == null && c == null) {
                m.put(ch, sPart);
                m2.put(sPart, ch);
            } else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog")); // true
        System.out.println(wordPattern("abba", "dog cat cat fish")); // false
        System.out.println(wordPattern("aaaa", "dog cat cat dog")); // false
    }
}
