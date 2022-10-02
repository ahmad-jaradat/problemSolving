package leetcode.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Stream;

/*
There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). 
The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. 
Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.

You want to determine if there is a valid path that exists from vertex source to vertex destination.

Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.

 

Example 1:

Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
Output: true
Explanation: There are two paths from vertex 0 to vertex 2:
- 0 → 1 → 2
- 0 → 2

Example 2:

Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
Output: false
Explanation: There is no path from vertex 0 to vertex 5.

 

Constraints:

    1 <= n <= 2 * 105
    0 <= edges.length <= 2 * 105
    edges[i].length == 2
    0 <= ui, vi <= n - 1
    ui != vi
    0 <= source, destination <= n - 1
    There are no duplicate edges.
    There are no self edges.


 */
public class FindIfPathExistsInGraph {

	private static boolean validPath(int n, int[][] edges, int start, int end) {
		HashSet<Integer>[] g = new HashSet[n];
		HashSet<Integer> visited = new HashSet<>();
		
		for (int i = 0; i < n; i++)
			g[i] = new HashSet<>();
		
		for (int[] edge : edges) {
			g[edge[0]].add(edge[1]);
			g[edge[1]].add(edge[0]);
		}
		visited.add(start);
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);

		while (queue.peek() != null) {
			Integer v = queue.remove();
			if (v == end)
				return true;
			for (Integer a : g[v]) {
				if (visited.add(a)) {
					queue.add(a);
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(validPath(3, new int[][] { { 0, 1 }, { 1, 2 }, { 2, 0 } }, 0, 2));// true
		System.out.println(validPath(6, new int[][] { { 0, 1 }, { 0, 2 }, { 3, 5 }, { 5, 4 }, { 4, 3 } }, 0, 5));// false
		System.out.println(validPath(50,
				new int[][] { { 31, 5 }, { 10, 46 }, { 19, 31 }, { 5, 1 }, { 31, 28 }, { 28, 29 }, { 8, 26 },
						{ 13, 23 }, { 16, 34 }, { 30, 1 }, { 16, 18 }, { 33, 46 }, { 27, 35 }, { 2, 25 }, { 49, 33 },
						{ 44, 19 }, { 22, 26 }, { 30, 13 }, { 27, 12 }, { 8, 16 }, { 42, 13 }, { 18, 3 }, { 21, 20 },
						{ 2, 17 }, { 5, 48 }, { 41, 37 }, { 39, 37 }, { 2, 11 }, { 20, 26 }, { 19, 43 }, { 45, 7 },
						{ 0, 21 }, { 44, 23 }, { 2, 39 }, { 27, 36 }, { 41, 48 }, { 17, 42 }, { 40, 32 }, { 2, 28 },
						{ 35, 38 }, { 3, 9 }, { 41, 30 }, { 5, 11 }, { 24, 22 }, { 39, 5 }, { 40, 31 }, { 18, 35 },
						{ 23, 39 }, { 20, 24 }, { 45, 12 } },
				29, 46));// false

	}
}
