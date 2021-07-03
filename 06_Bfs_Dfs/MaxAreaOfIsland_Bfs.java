package Bfs_Dfs;

import java.util.*;

public class MaxAreaOfIsland_Bfs {
	public static void main(String[] args) {

		int[][] grid = {
				{ 1, 0, 1, 1, 0 }, 
				{ 1, 1, 0, 0, 1 }, 
				{ 0, 1, 1, 1, 0 }, 
				{ 0, 0, 0, 0, 1 }, 
				{ 1, 1, 1, 0, 0 } 
				};
		
		MaxAreaOfIsland_Bfs a = new MaxAreaOfIsland_Bfs();
		System.out.println(a.solve_bfs(grid));
	}
	
	int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	int m, n;
	
	public int solve_bfs(int[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		int max = 0;
	    m = grid.length;
	    n = grid[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					grid[i][j] = 0;
					int area = bfs(grid, i, j);
					max = Math.max(max, area);
				}
			}
		}
		return max;
	}

	private int bfs(int[][] grid, int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { i, j });
		int res = 0;

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			res++;
			for (int[] dir : dirs) {
				int x = curr[0] + dir[0];
				int y = curr[1] + dir[1];
				if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
					grid[x][y] = 0;
					q.offer(new int[] { x, y });
				}
			}
		}
		return res;
	}
}
