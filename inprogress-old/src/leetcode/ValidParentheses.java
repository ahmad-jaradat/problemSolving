package leetcode;

import java.util.*;

/*
`Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.

Example 1:

Input: s = "()"
Output: true

Example 2:

Input: s = "()[]{}"
Output: true

Example 3:

Input: s = "(]"
Output: false



Constraints:

    1 <= s.length <= 104
    s consists of parentheses only '()[]{}'.
 */
public class ValidParentheses {
    private static boolean isClosedCorrectly(String s) {
        Deque<Character> stack = new LinkedList<>();
        Map<Character, Character> parentheses = new HashMap<Character, Character>() {{
            put('{', '}');
            put('[', ']');
            put('(', ')');
        }};
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (parentheses.containsKey(ch[i]))
                stack.addFirst(ch[i]);
            else if (parentheses.containsValue(ch[i])) {
                Character character = stack.pollFirst();
                if (character == null)
                    return false;
                if (ch[i] == '}' && '{' != character)
                    return false;
                if (ch[i] == ')' && '(' != character)
                    return false;
                if (ch[i] == ']' && '[' != character)
                    return false;
            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isClosedCorrectly("()")); // true
        System.out.println(isClosedCorrectly("()[]{}")); // true
        System.out.println(isClosedCorrectly("(]")); // false
        System.out.println(isClosedCorrectly("(a + (b +c))"));// true
        System.out.println(isClosedCorrectly("(a + [b +c))")); // false
        System.out.println(isClosedCorrectly("(a + [b + {([])} c])"));// true
    }
}
