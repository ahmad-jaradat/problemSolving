package leetcode;

/*
You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). 
The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island.

One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. 

Determine the perimeter of the island.


Example 1:

	Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
	Output: 16
	Explanation: The perimeter is the 16 yellow stripes in the image above.

Example 2:

	Input: grid = [[1]]
	Output: 4

Example 3:

	Input: grid = [[1,0]]
	Output: 4

*/
public class IslandPerimeter {

	private static int islandPerimeter(int[][] grid) {
		int result = 0;
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[r].length; c++) {
				if (grid[r][c] == 1) {
					if (r == 0)
						result++;
					if (r == grid.length - 1)
						result++;
					if (c == 0)
						result++;
					if (c == grid[r].length - 1)
						result++;
					if (r > 0 && grid[r - 1][c] == 0)
						result++;
					if (r < grid.length - 1 && grid[r + 1][c] == 0)
						result++;
					if (c > 0 && grid[r][c - 1] == 0)
						result++;
					if (c < grid[r].length - 1 && grid[r][c + 1] == 0)
						result++;
				}
			}
		}
		return result;
	}

	private static int island(int[][] grid) {
		int islands = 0, neighbours = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					islands++; // count islands
					if (i < grid.length - 1 && grid[i + 1][j] == 1)
						neighbours++; // count down neighbours
					if (j < grid[i].length - 1 && grid[i][j + 1] == 1)
						neighbours++; // count right neighbours
				}
			}
		}

		return islands * 4 - neighbours * 2;
	}

	public static void main(String[] args) {
		System.out.println(
				islandPerimeter(new int[][] { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } }));
		System.out.println(islandPerimeter(new int[][] { { 1 } }));
		System.out.println(islandPerimeter(new int[][] { { 1, 0 } }));
		
		System.out.println(
				island(new int[][] { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } }));
		System.out.println(island(new int[][] { { 1 } }));
		System.out.println(island(new int[][] { { 1, 0 } }));
	}
}
