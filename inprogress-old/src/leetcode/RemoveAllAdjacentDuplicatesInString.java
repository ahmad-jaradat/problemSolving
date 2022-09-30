package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*
You are given a string s consisting of lowercase English letters.
A duplicate removal consists of choosing two adjacent and equal letters and removing them.

We repeatedly make duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.



Example 1:

Input: s = "abbaca"
Output: "ca"
Explanation:
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".

Example 2:

Input: s = "azxxzy"
Output: "ay"



Constraints:

    1 <= s.length <= 105
    s consists of lowercase English letters.


 */
public class RemoveAllAdjacentDuplicatesInString {
    private static String removeDuplicates(String s) {
        Deque<Character> q = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            Character h = q.peekFirst();
            char c = s.charAt(i);
            if (h != null && h == c) {
                q.removeFirst();
            } else {
                q.addFirst(c);
            }
        }
        String r = "";
        while (!q.isEmpty()) {
            r = q.removeFirst() + r;
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca")); // ca
        System.out.println(removeDuplicates("azxxzy")); // ay
    }
}
