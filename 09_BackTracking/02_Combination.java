package Permutation;

import java.util.*;

public class Combination {

	public static void main(String[] args) {
		int n = 3, k = 2;
		System.out.println(new Combination().solve(n,k));
	}

	public List<List<Integer>> solve(int n, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		backtrack(result, new ArrayList<Integer>(), n, k, 1);
		return result;
	}

	public void backtrack(List<List<Integer>> result, ArrayList<Integer> tempList, int n, int k, int start) {
		if (tempList.size() == k) {
			result.add(new ArrayList<>(tempList));
	//	    System.out.println("add tempList: "+tempList);
		}else if (tempList.size() > k) {
		//	System.out.println("return tempList: "+tempList);
			return;
		}
		

		for (int i = start; i <= n; i++) {
			tempList.add(i);
			//System.out.println("22tempList: "+tempList);
			backtrack(result, tempList, n, k, i + 1);
			tempList.remove(tempList.size() - 1);
		//	System.out.println("remove tempList: "+tempList);
		}
	}
}
