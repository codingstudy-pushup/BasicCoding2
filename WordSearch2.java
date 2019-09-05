package am;

import java.util.*;

public class WordSearch2 {

//		Time: a * m * n * (4 ^ l )
//		a is the size of words
//		m*n is board size
//		l is the length of string and (4 ^ l ) means Math.pow(4, l)
//		Space: m * n
	public static void main(String[] args) {
		char[][] grid = { { 'o', 'a', 'a', 'n' },
				          { 'e', 't', 'a', 'e' }, 
				          { 'i', 'h', 'k', 'r' },
				          { 'i', 'f', 'l', 'v' } };
		String[] words = { "oath", "pea", "eat", "rain" };
		WordSearch2 a = new WordSearch2();
		System.out.println(a.solve(grid, words));
	}

	int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
	int m, n ;
	public List<String> solve(char[][] board, String[] words) {
		List<String> result = new ArrayList<>();

		int m = board.length;
		int n = board[0].length;
		for (String word : words) {
			boolean[][] visited = new boolean[m][n];
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					if (board[i][j] == word.charAt(0) && dfs(board, visited, i, j, word, 0)) {
						if (!result.contains(word))
							result.add(word);
					}
				}
			}
		}
		return result;
	}

	private boolean dfs(char[][] board, boolean[][] visited, int x, int y, String word, int index) {
		if (index == word.length())
			return true;
	
		if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y]|| board[x][y] != word.charAt(index)) {
			return false;
		}

	
		for (int[] dir: dirs){
		     int x1=x+dir[0];
		     int y1=y+dir[1];
		        System.out.println("x1: "+x1+" y1: "+y1);
		        if (dfs(board, visited, x1, y1, word, index+1 )){
		            return true;
		        }
		    }
		visited[x][y] = false;
		
//		if (dfs(board, visited, i + 1, j, s, index + 1) ||
//			dfs(board, visited, i - 1, j, s, index + 1) ||
//			dfs(board, visited, i, j + 1, s, index + 1) ||
//			dfs(board, visited, i, j - 1, s, index + 1)) {
//			return true;
//		}
//		visited[i][j] = false;

		return false;
	}

}
