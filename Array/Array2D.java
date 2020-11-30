

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array2D {

	public static void main(String[] args) {
		List<List<Integer>> list = new ArrayList<>();
		
		for(int i=0; i<3; i++) {
			List<Integer> integers = new ArrayList<Integer>();
			for(int j=0; j<4; j++) {
				integers.add(i);
			}
			list.add(integers);
		}
		
		int[][] array =new int[list.size()][];
		
		for(int i=0 ; i< array.length ; i++) {
			array[i] = new int[list.get(i).size()];
		}
		
		for(int i=0; i<list.size(); i++) {
			for(int j=0; j<list.get(i).size(); j++) {
				System.out.print(" "+i+""+j+", ");
				array[i][j] = list.get(i).get(j);
			}
			System.out.println();
		}
		System.out.println(Arrays.deepToString(array));
		
	}
}
