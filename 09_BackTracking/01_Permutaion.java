package Permutation;

import java.util.*;

public class Permutaion {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		System.out.println(new Per().solve(nums));
	}

	public List<List<Integer>> solve(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> tempList = new ArrayList<>();
		backtrack(list, tempList, nums);
		return list;
	}
	int count =0;
	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
		System.out.println("tempList: "+tempList);
		count++;
		System.out.println("count "+count);
		if (tempList.size() == nums.length) {
			list.add(new ArrayList<>(tempList));
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (tempList.contains(nums[i]))
					continue; // element already exists, skip
				System.out.println("i "+i);
				tempList.add(nums[i]);
				System.out.println("22tempList: "+tempList);
				backtrack(list, tempList, nums);
				tempList.remove(tempList.size() - 1);
				System.out.println("33tempList: "+tempList);
			}
		}
	}
}
