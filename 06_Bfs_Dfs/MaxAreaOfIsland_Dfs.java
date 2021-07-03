package Bfs_Dfs;

public class MaxAreaOfIsland_Dfs {

	public static void main(String[] args) {

		int[][] grid = { 
				{ 1, 0, 1, 1, 0 }, 
				{ 1, 1, 0, 0, 1 }, 
				{ 0, 1, 1, 1, 0 }, 
				{ 0, 0, 0, 0, 1 },
				{ 1, 1, 1, 0, 0 } };

		MaxAreaOfIsland_Dfs a = new MaxAreaOfIsland_Dfs();
		System.out.println(a.solve_dfs(grid));
	}

	int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	int m, n;

	public int solve_dfs(int[][] grid) {
		m = grid.length;
		n = grid[0].length;
		int max = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					int area = dfs(grid, i, j);
					max = Math.max(max, area);
				}
			}
		}
		return max;
	}

	public int dfs(int[][] grid, int i, int j) {
		if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0)
			return 0;
		int area = 1;
		grid[i][j] = 0;
		for (int[] dir : dirs) {
			int x = i + dir[0];
			int y = j + dir[1];
			area += dfs(grid, x, y);
		}
		return area;
	}
}
