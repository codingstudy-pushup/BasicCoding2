package Bfs_Dfs;
import java.util.*;


public class Basic_bfs02 {

		public static void main(String[] args) {
			Basic_bfs02 a = new Basic_bfs02();
//			int x =2, y=1;
			int x =5, y=5;
			System.out.println(a.minKnightMoves(x, y));
			
		}
		
		
	private final int[][] DIRECTIONS = new int[][] {
		{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
	    
	    public int minKnightMoves(int x, int y) {
	        x = Math.abs(x);
	        y = Math.abs(y);
	        
	        Queue<int[]> queue = new LinkedList<>();
	        queue.add(new int[] {0, 0});
	        
	        Set<String> visited = new HashSet<>();
	        visited.add("0,0");
	        
	        int result = 0;
	        while (!queue.isEmpty()) {
	            int size = queue.size();
	            for (int i = 0; i < size; i++) {
	                int[] cur = queue.remove();
	                int curX = cur[0];
	                int curY = cur[1];
	                if (curX == x && curY == y) {
	                    return result;
	                }
	                
	                for (int[] d : DIRECTIONS) {
	                    int newX = curX + d[0];
	                    int newY = curY + d[1];
	                    if (!visited.contains(newX + "," + newY)
	                    	&& newX >= -1
	                    	&& newY >= -1) {
	                        queue.add(new int[] {newX, newY});
	                        visited.add(newX + "," + newY);
	                    }
	                }
	            }
	            result++;
	        }
	        return -1;
	    }
	

}
