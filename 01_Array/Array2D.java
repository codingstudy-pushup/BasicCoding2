
package String_Array;

public class Array2D {
	
	public static void main(String[] args) {
		Array2D a = new Array2D();
		
		//1. 2차원배열의 크기가 같다
		int[][] grid = new int[3][4];
		System.out.println("===1번======");
		a.print(grid);
		
		grid[0][1]=16;
		System.out.println("===after======");
		a.print(grid);
		
		
		//2. 2차원배열크기가 다른경우
		int[][] grid2 = new int[3][];
		System.out.println("===2번======");
//		a.print(grid2);
		grid2[0] = new int[1];
		grid2[1] = new int[1];
		grid2[2] = new int[5];
		System.out.println("===after======");
		a.print(grid2);
		
		//3. 초기화와 동시에 값을 넣을때
		int[][] grid3 = {{1,2},
				         {0,0,3},
		                 {4,5,6}} ;
		
		System.out.println("===3 after======");
		a.print(grid3);
		
	}
	
	//1. 
	public void print(int[][] grid) {
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[i].length; j++) {
				System.out.print(grid[i][j]+" ");
			}
			System.out.println();
		}
	}

}
