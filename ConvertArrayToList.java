import java.util.*;

public class ListTest {

	public static void main(String[] args) {
		int[][] nums = { { 1, 2 }, { 2, 3 } };
		System.out.println(convert_ArrayTolist(nums));
		List<List<Integer>> result = convert_ArrayTolist(nums);
		int[][] array = convert_ListToArray(result);
	}
	private static List<List<Integer>> convert_ArrayTolist(int[][] nums) {
		List<List<Integer>> result = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			List<Integer> sList = new ArrayList<>();
			for (int j = 0; j < nums[i].length; j++) {
				sList.add(nums[i][j]);
			}
			result.add(sList);
		}
		return result;
	}
	
	private static int[][] convert_ListToArray(List<List<Integer>> list){
		int[][] array = new int[list.size()][];
		
		for(int i=0; i<array.length; i++) {
			array[i] = new int[list.get(i).size()];
		}
		for(int i=0; i<list.size(); i++) {
			for(int j=0; j<list.get(i).size(); j++) {
				array[i][j] = list.get(i).get(j);
			}
		}
		return array;
	}
	
}
