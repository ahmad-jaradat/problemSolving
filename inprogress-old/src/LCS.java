import java.util.Arrays;

public class LCS {
    private static int countA = 0;

    private static int lcs(char[] a, char[] b, int aIndex, int bIndex) {
        countA++;
        if (aIndex == a.length || bIndex == b.length)
            return 0;
        if (a[aIndex] == b[bIndex])
            return 1 + lcs(a, b, aIndex + 1, bIndex + 1);
        else
            return Math.max(lcs(a, b, aIndex + 1, bIndex), lcs(a, b, aIndex, bIndex + 1));
    }

    private static int countB = 0;
    private static int[][] result;

    private static int lcs2(char[] a, char[] b, int aIndex, int bIndex) {
        if (countB == 0) {
            result = new int[a.length][b.length];
            for (int i = 0; i < result.length; i++)
                Arrays.fill(result[i], -1);
        }
        countB++;

        if (aIndex == a.length || bIndex == b.length)
            return 0;
        if (result[aIndex][bIndex] != -1)
            return result[aIndex][bIndex];
        if (a[aIndex] == b[bIndex])
            return result[aIndex][bIndex] = 1 + lcs2(a, b, aIndex + 1, bIndex + 1);
        else
            return result[aIndex][bIndex] = Math.max(lcs2(a, b, aIndex + 1, bIndex), lcs2(a, b, aIndex, bIndex + 1));
    }

    private static int countC = 0;

    private static int lcs3(char[] a, char[] b) {
        int[][] table = new int[a.length + 1][b.length + 1];
        for (int i = a.length - 1; i >= 0; i--)
            for (int j = b.length - 1; j >= 0; j--) {
                countC++;
                if (a[i] == b[j]) {
                    table[i][j] = 1 + table[i + 1][j + 1];
                } else {
                    table[i][j] = Math.max(table[i + 1][j], table[i][j + 1]);
                }
            }
        return table[0][0];
    }

    public static void main(String[] args) {
        System.out.println(lcs("ABCDGH".toCharArray(), "AEDFHR".toCharArray(), 0, 0));
        System.out.println(countA);
        System.out.println(lcs("AGGTAB".toCharArray(), "GXTXAYB".toCharArray(), 0, 0));
        System.out.println(countA);

        System.out.println("\\//\\//\\//\\//\\//\\//\\//\\//");
        System.out.println(lcs2("ABCDGH".toCharArray(), "AEDFHR".toCharArray(), 0, 0));
        System.out.println(countB);
        countB = 0;
        System.out.println(lcs2("AGGTAB".toCharArray(), "GXTXAYB".toCharArray(), 0, 0));
        System.out.println(countB);

        System.out.println("\\//\\//\\//\\//\\//\\//\\//\\//");
        System.out.println(lcs3("ABCDGH".toCharArray(), "AEDFHR".toCharArray()));
        System.out.println(countC);
        countC = 0;
        System.out.println(lcs3("AGGTAB".toCharArray(), "GXTXAYB".toCharArray()));
        System.out.println(countC);

    }
}
