package Bfs_Dfs;

public class Basic_dfs02 {

	public static void main(String[] args) {
		int[][] grid = { { 9, 8, 3 },
				         { 6, 5, 7 }, 
				         { 2, 1, 1 } };

		Basic_dfs02 a = new Basic_dfs02();
		System.out.println(a.solve(grid));
	}

	public static final int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public int solve(int[][] matrix) {
		if (matrix.length == 0)
			return 0;
		int m = matrix.length, n = matrix[0].length;
		int[][] result = new int[m][n];
		int max = 1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.println();
				int len = dfs(matrix, i, j, m, n, result);
				max = Math.max(max, len);
			}
			System.out.println();
		}
		return max;
	}

	public int dfs(int[][] matrix, int i, int j, int m, int n, int[][] result) {
		if (result[i][j] != 0)
			return result[i][j];
		int max = 1;
		for (int[] dir : dirs) {
			int x = i + dir[0]; 
			int y = j + dir[1];
			
			if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j])
				continue;
			int len = 1 + dfs(matrix, x, y, m, n, result);
			max = Math.max(max, len);
			System.out.println("==cache===");
			print(result);
		}
		result[i][j] = max;
		return max;
	}
	
	void print(int[][] grid) {
		for(int i=0; i<grid.length; i++) {
//			System.out.print("grid["+i+"] "+grid[i].length+"\t");
			for(int j=0; j<grid[i].length; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
	}

}
