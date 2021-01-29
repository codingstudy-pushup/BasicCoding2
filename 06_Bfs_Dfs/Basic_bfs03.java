package Bfs_Dfs;

import java.util.*;



public class Basic_bfs03 {

	public static void main(String[] args) {

		Basic_bfs03 a = new Basic_bfs03();

		
		int[][] grid = {
				{ 0, 0, 3, 3 }, 
				{ 1, 4, 0, 1 }, 
				{ 1, 0, 0, 1 }, 
				{ 1, 0, 0, 1 }, 
				{ 1, 2, 2, 0 },
				{ 1, 1, 0, 0 } };
		
		int[] result = a.solution(grid);
		for (int i : result) {
			System.out.println("i: " + i);
		}
		
//		System.out.println(Arrays.toString(a.solution(grid)));
	}

	int count = 0;
	boolean[][] visited;
	int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    int m=0, n=0;
    
	public int[] solution(int[][] grid) {
		int maxSize = 0;
		m = grid.length;
		n = grid[0].length;
		visited = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j] || grid[i][j]==0) {
					continue;
				}

				count++;
				int thisAreaSize = bfs(grid, i, j,  visited);
				System.out.println("======thisAreaSize: "+thisAreaSize);
				maxSize = Math.max(maxSize, thisAreaSize);
			}
		}

		int[] result = new int[2];
		result[0] = count;
		result[1] = maxSize;
		return result;

	}

	public int bfs(int[][] grid, int i, int j, boolean[][] visited) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { i, j }); // first start queue
//		System.out.println("i: "+i+" j "+j);
		visited[i][j] = true;
		int thisNumAreaSize = 0;
		
		while (!queue.isEmpty()) {
			int[] point = queue.poll();
			thisNumAreaSize++;
//            System.out.println("thisNumAreaSize: "+thisNumAreaSize);
			for (int[] dir : dirs) {
				int newX = point[0] + dir[0];
				int newY = point[1] + dir[1];
				if (newX >= 0 && newY >= 0 && newX < m && newY < n) {
					System.out.println("grid[i][j]  "+grid[i][j] +" grid[newX][newY] "+grid[newX][newY]);
					if (!visited[newX][newY] && grid[i][j] == grid[newX][newY]) {
						queue.add(new int[] { newX, newY });
						visited[newX][newY] = true;
					}
				}
			}
		}
		return thisNumAreaSize;
	}

}
