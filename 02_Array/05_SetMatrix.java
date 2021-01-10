package Array;

import java.util.*;

public class SetMatrix {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
//		int[][] matrix ={
//				  {1,1,1,1},
//				  {1,0,1,1},
//				  {1,1,0,0},
//				  {0,0,0,1},
//				};
		SetMatrix a = new SetMatrix();
		a.print(matrix);
		a.solve(matrix);
		System.out.println("====result=======");
		a.print(matrix);
	}

	public void solve(int[][] grid) {

		Set<Integer> rowSet = new HashSet<>();
		Set<Integer> colSet = new HashSet<>();

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 0) {
					rowSet.add(i);
					colSet.add(j);
				}
			}
		}

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (rowSet.contains(i) || colSet.contains(j)) {
					grid[i][j] = 0;
				}
			}
		}
	}

	public void print(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(" [" + i + "][" + j + "] " + grid[i][j]);
			}
			System.out.println();
		}
	}

}
