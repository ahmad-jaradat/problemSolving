package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a matrix of dimension m*n where each cell in the matrix can have values 0, 1 or 2 which has the following meaning:  

0: Empty cell
1: Cells have fresh oranges
2: Cells have rotten oranges

Determine what is the minimum time required so that all the oranges become rotten. A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right). If it is impossible to rot every orange then simply return -1.

Examples: 

Input:  arr[][C] = { {2, 1, 0, 2, 1},
                     {1, 0, 1, 2, 1},
                     {1, 0, 0, 2, 1}};
Output:
All oranges can become rotten in 2-time frames.
Explanation: 
At 0th time frame:
 {2, 1, 0, 2, 1}
 {1, 0, 1, 2, 1}
 {1, 0, 0, 2, 1}

At 1st time frame:
 {2, 2, 0, 2, 2}
 {2, 0, 2, 2, 2}
 {1, 0, 0, 2, 2}

At 2nd time frame:
 {2, 2, 0, 2, 2}
 {2, 0, 2, 2, 2}
 {2, 0, 0, 2, 2}


Input:  arr[][C] = { {2, 1, 0, 2, 1},
                     {0, 0, 1, 2, 1},
                     {1, 0, 0, 2, 1}};
Output:
All oranges cannot be rotten.
Explanation: 
At 0th time frame:
{2, 1, 0, 2, 1}
{0, 0, 1, 2, 1}
{1, 0, 0, 2, 1}

At 1st time frame:
{2, 2, 0, 2, 2}
{0, 0, 2, 2, 2}
{1, 0, 0, 2, 2}

At 2nd time frame:
{2, 2, 0, 2, 2}
{0, 0, 2, 2, 2}
{1, 0, 0, 2, 2}
...
The 1 at the bottom left corner of the matrix is never rotten.
 */
public class MinimumTimeRequiredToRotAllOranges {

	private static int timeRequired(int[][] arr) {
		Queue<Pair> queue = new LinkedList<>();
		Queue<Pair> tmp = new LinkedList<>();
		
		int levelCount = 0;
		int rottenCount = 0;
		int orangeCount = 0;
		
		for (int i = 0; i < arr.length; i++)
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == 2) {
					tmp.add(new Pair(i, j));
					rottenCount++;
					orangeCount++;
				} else if (arr[i][j] == 1)
					orangeCount++;
			}

		while (!tmp.isEmpty()) {
			queue = tmp;
			tmp = new LinkedList<>();
			levelCount++;
			
			while (!queue.isEmpty()) {
				Pair p = queue.remove();
				int row = p.val1;
				int col = p.val2;

				row--;
				if (getValue(row, col, arr) == 1) {
					tmp.add(new Pair(row, col));
					arr[row][col] = 2;
					rottenCount++;
				}
				
				row += 2;
				if (getValue(row, col, arr) == 1) {
					tmp.add(new Pair(row, col));
					arr[row][col] = 2;
					rottenCount++;
				}
				
				row--;
				col--;
				if (getValue(row, col, arr) == 1) {
					tmp.add(new Pair(row, col));
					arr[row][col] = 2;
					rottenCount++;
				}
				
				col += 2;
				if (getValue(row, col, arr) == 1) {
					tmp.add(new Pair(row, col));
					arr[row][col] = 2;
					rottenCount++;
				}
			}
		}

		return orangeCount != rottenCount ? -1 : levelCount;
	}

	private static int getValue(int row, int col, int[][] arr) {
		if (row < arr.length && col < arr[0].length && (row >= 0 && col >= 0))
			return arr[row][col];
		return -1;
	}

	public static void main(String[] args) {
		int[][] arr = new int[][] { { 2, 1, 0, 2, 1 }, { 1, 0, 1, 2, 1 }, { 1, 0, 0, 2, 1 } };
		System.out.println(timeRequired(arr));
		arr = new int[][] { { 2, 1, 0, 2, 1 }, { 0, 0, 1, 2, 1 }, { 0, 0, 0, 2, 1 } };
		System.out.println(timeRequired(arr));
		arr = new int[][] { 
			{ 2, 1, 0, 2, 1 }, 
			{ 0, 0, 1, 2, 1 }, 
			{ 0, 1, 0, 2, 1 } };
		System.out.println(timeRequired(arr));
	}

	private static class Pair {
		int val1;
		int val2;

		Pair(int val1, int val2) {
			this.val1 = val1;
			this.val2 = val2;
		}
	}

}
