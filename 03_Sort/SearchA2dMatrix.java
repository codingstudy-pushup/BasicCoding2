
public class SearchA2dMatrix {

	public static void main(String[] args) {
		int[][] matrix = { { 1,  3,  5,  7 },
				           { 10, 11, 16, 20 },
				           { 23, 30, 34, 50 } };
		int target = 33;
		System.out.println(searchMatrix(matrix, target));
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length < 1 || matrix[0].length < 1)
			return false;

		int col = 0;
		int row = matrix.length - 1;
		while (col <= matrix[0].length - 1 && row >= 0) {
			if (target == matrix[row][col])
				return true;
			else if (target < matrix[row][col])
				row--;
			else if (target > matrix[row][col])
				col++;
		}
		return false;
	}
