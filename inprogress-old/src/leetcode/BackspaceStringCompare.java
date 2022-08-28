package leetcode;

/*
Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.



Example 1:

    Input: s = "ab#c", t = "ad#c"
    Output: true
    Explanation: Both s and t become "ac".

Example 2:

    Input: s = "ab##", t = "c#d#"
    Output: true
    Explanation: Both s and t become "".

Example 3:

    Input: s = "a#c", t = "b"
    Output: false
    Explanation: s becomes "c" while t becomes "b".



Constraints:

    1 <= s.length, t.length <= 200
    s and t only contain lowercase letters and '#' characters.

 */
public class BackspaceStringCompare {
    private static boolean backspaceCompare(String s, String t) {
        char[] sA = removeWhite(s.toCharArray());
        char[] tA = removeWhite(t.toCharArray());
        int iS = sA.length - 1;
        int iT = tA.length - 1;

        while (iS >= 0 && iT >= 0) {
            if (sA[iS--] != tA[iT--])
                return false;
        }
        while (iS >= 0)
            if (sA[iS--] != '#')
                return false;
        while (iT >= 0)
            if (tA[iT--] != '#')
                return false;
        return true;
    }

    private static char[] removeWhite(char[] input) {
        int i = input.length - 1;
        int x = input.length - 1;
        while (x >= 0) {
            if (input[i] != '#')
                input[i--] = input[x];
            x--;
        }
        while (i >= 0)
            input[i--] = '#';
        return input;
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ad#c"));
        System.out.println(backspaceCompare("ab##", "c#d#"));
        System.out.println(backspaceCompare("a#c", "b"));
    }
}
