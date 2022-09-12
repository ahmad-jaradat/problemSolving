package leetcode;

/*

The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, return the Hamming distance between them.

 

Example 1:
	
	Input: x = 1, y = 4
	Output: 2
	Explanation:
	1   (0 0 0 1)
	4   (0 1 0 0)
	       ↑   ↑
	The above arrows point to positions where the corresponding bits are different.

Example 2:
	
	Input: x = 3, y = 1
	Output: 1

 */
public class HammingDistance {
	private static int hammingDistance(int x, int y) {
        int r = 0;
		for (int i = 1; i < Integer.MAX_VALUE && i > 0; i = i * 2) {
			if (((x & i) ^ (y & i)) > 0)
				r++;
		}
		return r;
	}

	public static void main(String[] args) {
		System.out.println(hammingDistance(1, 4));
		System.out.println(hammingDistance(3, 1));
	}
}
