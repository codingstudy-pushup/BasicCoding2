

import java.util.*;

public class SetMatrix {
	public static void main(String[] args) {
		int[][] matrix ={
				  {1,1,1},
				  {1,0,1},
				  {1,1,1}
				};
//		int[][] matrix ={
//				  {1,1,1,1},
//				  {1,0,1,1},
//				  {1,1,0,0},
//				  {0,0,0,1},
//				};
		print(matrix);
		System.out.println("===!!=========");
		setZeroes2(matrix);
		System.out.println("============");
		print(matrix);
	}
	static void print(int[][] grid) {
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[i].length; j++) {
				System.out.print("["+i+"]["+j+"] "+grid[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void setZeroes2(int[][] matrix) {
	    int R = matrix.length;
	    int C = matrix[0].length;
	    Set<Integer> rows = new HashSet<>();
	    Set<Integer> cols = new HashSet<>();

	    // Essentially, we mark the rows and columns that are to be made zero
	    for (int i = 0; i < R; i++) {
	      for (int j = 0; j < C; j++) {
	        if (matrix[i][j] == 0) {
	          rows.add(i);
	          cols.add(j);
	        }
	      }
	    }

	    // Iterate over the array once again and using the rows and cols sets, update the elements.
	    for (int i = 0; i < R; i++) {
	      for (int j = 0; j < C; j++) {
	        if (rows.contains(i) || cols.contains(j)) {
	          matrix[i][j] = 0;
	        }
	      }
	    }
	  }
	
	
	public static void setZeroes(int[][] matrix) {
	    boolean fr = false,fc = false;
	    for(int i = 0; i < matrix.length; i++) {
	        for(int j = 0; j < matrix[0].length; j++) {
	        	
	            if(matrix[i][j] == 0) {
	            	System.out.print("["+i+"]["+j+"] "+matrix[i][j]);
	                if(i == 0) fr = true;
	                if(j == 0) fc = true;
	                matrix[0][j] = 0;
	                matrix[i][0] = 0;
	            }
	        }
	    }
	    System.out.println("");
	    System.out.println("====1111======");
		print(matrix);
	    
	    for(int i = 1; i < matrix.length; i++) {
	        for(int j = 1; j < matrix[0].length; j++) {
	            if(matrix[i][0] == 0 || matrix[0][j] == 0) {
	            	System.out.print(" $$$  ["+i+"]["+j+"] "+matrix[i][j]);
	                matrix[i][j] = 0;
	            }
	        }
	    }
	    
	    System.out.println("");
	    System.out.println("====2222=====");
		print(matrix);
	    
	    
		 System.out.println("fr "+fr+" fc "+fc);
	    if(fr) {
	        for(int j = 0; j < matrix[0].length; j++) {
	            matrix[0][j] = 0;
	        }
	        
	        System.out.println("");
		    System.out.println("====3333====");
			print(matrix);
	    }
	    if(fc) {
	        for(int i = 0; i < matrix.length; i++) {
	            matrix[i][0] = 0;
	        }
	        System.out.println("");
		    System.out.println("====4444====");
			print(matrix);
	    }
	}

}
