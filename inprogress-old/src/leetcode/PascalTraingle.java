package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

 

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

Example 2:

Input: numRows = 1
Output: [[1]]

 */
public class PascalTraingle {
	private static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new LinkedList<>();
		List<Integer> preRow = new ArrayList<>();
		for (int i = 1; i <= numRows; i++) {
			Integer[] row = new Integer[i];
			row[0] = 1;
			row[row.length - 1] = 1;
			for (int j = 2; j < i; j++)
				row[j - 1] = preRow.get(j - 1) + preRow.get(j - 2);
			preRow = Arrays.asList(row);
			result.add(preRow);
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(generate(1));
		System.out.println(generate(5));

	}
}
