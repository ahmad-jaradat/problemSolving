package leetcode;

/*
In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order.
The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted
lexicographically in this alien language.



Example 1:

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.

Example 2:

Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.

Example 3:

Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).



Constraints:

    1 <= words.length <= 100
    1 <= words[i].length <= 20
    order.length == 26
    All characters in words[i] and order are English lowercase letters.


 */
public class VerifyingAnAlienDictionary {
    private static boolean isAlienSorted(String[] words, String order) {
        int[] o = order(order);
        for (int i = 1; i < words.length; i++) {
            char[] s1 = words[i - 1].toCharArray();
            char[] s2 = words[i].toCharArray();
            if (compare(o, s1, s2))
                return false;

        }
        return true;
    }

    private static boolean compare(int[] o, char[] s1, char[] s2) {
        int j;
        for (j = 0; j < s1.length && j < s2.length; j++)
            if (o[s1[j] - 'a'] > o[s2[j] - 'a'])
                return true;
            else if (o[s1[j] - 'a'] < o[s2[j] - 'a'])
                return false;
        return j != s1.length ? true : false;
    }

    private static int[] order(String order) {
        int[] o = new int['z' - 'a' + 1];
        char[] oChar = order.toCharArray();
        for (int i = 0; i < 26; i++)
            o[oChar[i] - 'a'] = i;
        return o;
    }

    public static void main(String[] args) {
        System.out.println(isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz")); // true
        System.out.println(isAlienSorted(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz")); // false
        System.out.println(isAlienSorted(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz")); // false
        System.out.println(isAlienSorted(new String[]{"hello", "hello"}, "abcdefghijklmnopqrstuvwxyz")); // true

    }

}
