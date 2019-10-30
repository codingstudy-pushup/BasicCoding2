package top50;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Maze02 {
	
		public static void main(String[] args) {
			Maze02 a = new Maze02();
			int[][] maze = {
					   {0,0,1,0,0},
					   {0,0,0,0,0},
					   {0,0,0,1,0},
					   {1,1,0,1,1},
					   {0,0,0,0,0}
			};
			
			int[] start = {0,4};
			int[] dest= {4,4};
			System.out.println(a.shortestDistance(maze, start, dest));
		}
		  // directions to top, bottom, left and right
	    int[][] dirs={{-1,0},{1,0},{0,-1},{0,1}};
	    int m , n;
		public int shortestDistance(int[][] maze, int[] start, int[] dest) {
			m = maze.length;
		 	n = maze[0].length;
	        int[][] distance = new int[m][n];
	        for (int[] row: distance)
	            Arrays.fill(row, 1000);
	        distance[start[0]][start[1]] = 0;
	
	        Queue < int[] > queue = new LinkedList < > ();
	        queue.add(start);
	        while (!queue.isEmpty()) {
	        	System.out.println("==========================queue size "+queue.size());
	            int[] s = queue.remove();
	            for (int[] dir: dirs) {
	                int x = s[0] + dir[0];
	                int y = s[1] + dir[1];
	                int count = 0;
	       
	                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
	                	System.out.println("@@@ x: "+x+" y: "+y);
	                    x += dir[0];
	                    y += dir[1];
	                    count++;
	                    System.out.println("hhh x: "+x+" y: "+y+" count: "+count);
	                }
	                if (distance[s[0]][s[1]] + count < distance[x - dir[0]][y - dir[1]] ) {
	                	
	                	System.out.println((distance[s[0]][s[1]] + count)+" "+distance[x-dir[0]][y-dir[1]]+
	                			           " distance["+s[0]+"]"+"["+s[1]+"] "+distance[s[0]][s[1]]+
	                			           " count: "+count+
	                			           " distance["+(x-dir[0])+"]["+(y-dir[1])+"]"+distance[x - dir[0]][y - dir[1]]);
	                	
	                	System.out.println("x: "+x+" dir[0]: "+dir[0]+"  x - dir[0]: "+(x - dir[0])+" "+distance[x - dir[0]][y - dir[1]]);
	                	System.out.println("y: "+x+" dir[1]: "+dir[1]+"  y - dir[1]: "+(y - dir[1])+" "+distance[x - dir[0]][y - dir[1]]);
	                	
	                    distance[x - dir[0]][y - dir[1]] = distance[s[0]][s[1]] + count;
	                    
	                	System.out.println("value "+(x - dir[0])+" "+(y - dir[1])+" "+ distance[x - dir[0]][y - dir[1]]);
	                	System.out.println();
	                    queue.add(new int[] {x - dir[0], y - dir[1]});
	                }
	            }
	        }
	        print(distance);
	        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
	    }
		
		void print(int[][] dp) {
			System.out.println("===================================dp==");
			for (int i = 0; i < dp.length; i++) {
				for (int j = 0; j < dp[i].length; j++) {
					System.out.print(dp[i][j] + "\t");
				}
				System.out.println();
			}
			System.out.println("===================================dp==");
		}
		


}
