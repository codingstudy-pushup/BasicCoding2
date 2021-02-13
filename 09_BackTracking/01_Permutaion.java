package Permutation;

import java.util.*;

public class Permutation {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		System.out.println(new Permutation().solve(nums));
	}

	public List<List<Integer>> solve(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> tempList = new ArrayList<>();
		backtrack(result, tempList, nums);
		return result;
	}
	int count =0;
	private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
//		System.out.println("tempList: "+tempList);
//		count++;
//		System.out.println("count "+count);
		if (tempList.size() == nums.length) {
			result.add(new ArrayList<>(tempList));
		} else {
			for (int i = 0; i < nums.length; i++) {
			//	System.out.println("11tempList: "+tempList+" nums["+i+"]:"+nums[i]);	
				if (tempList.contains(nums[i])) {
			//	System.out.println("12tempList: "+tempList+" nums["+i+"]:"+nums[i]);	
					continue; 
				}
					
		//		System.out.println("i "+i);
				tempList.add(nums[i]);
		//		System.out.println("22tempList: "+tempList);
				backtrack(result, tempList, nums);
				tempList.remove(tempList.size() - 1);
		//		System.out.println("33tempList: "+tempList);
			}
		}
		//System.out.println("====end====================="+count );
	}
}
