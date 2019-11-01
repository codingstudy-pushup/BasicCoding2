package ama_onsi;

import java.util.*;

public class PathMinSum {
	public static void main(String[] args) {
		int[][] nums = { 
				{ 5, 4, 5 }, 
				{ 1, 2, 6 }, 
				{ 7, 4, 6 } };
		PathMinSum a = new PathMinSum();
		System.out.println(a.maximumMinimumPath(nums));
	}

	int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public int maximumMinimumPath(int[][] A) {
		int n = A.length;
		int m = A[0].length;
		boolean[][] visited = new boolean[n][m];

		// in the BFS approach, for each step, we are interested in getting the maximum
		// min that we have seen so far, thus we reverse the ordering in the pq
		Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);

		pq.offer(new int[] { 0, 0, A[0][0] });

		// BFS
		while (!pq.isEmpty()) {
			int[] cell = pq.poll();
			int row = cell[0];
			int col = cell[1];

			if (row == n - 1 && col == m - 1) {
				return cell[2];
			}

			visited[row][col] = true;

			for (int[] dir : dirs) {
				int nextRow = row + dir[0];
				int nextCol = col + dir[1];

				if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m || visited[nextRow][nextCol])
					continue;

				// we are keeping track of the min element that we have seen until now
				pq.offer(new int[] { nextRow, nextCol, Math.min(cell[2], A[nextRow][nextCol]) });
			}
		}
		return -1;
	}
}
