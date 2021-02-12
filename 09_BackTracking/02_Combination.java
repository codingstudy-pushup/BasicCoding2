package Permutation;

import java.util.*;

public class Combination {

	public static void main(String[] args) {
		int n = 3, k = 2;
		System.out.println(new Combination().solve(n,k));
	}

	public List<List<Integer>> solve(int n, int k) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		backtrack(list, new ArrayList<Integer>(), n, k, 1);
		return list;
	}

	public void backtrack(List<List<Integer>> list, ArrayList<Integer> templist, int n, int k, int start) {
		if (templist.size() == k) {
			list.add(new ArrayList<>(templist));
		    System.out.println("add tempList: "+templist);
		}else if (templist.size() > k) {
			System.out.println("return tempList: "+templist);
			return;
		}
		

		for (int i = start; i <= n; i++) {
			templist.add(i);
			System.out.println("22tempList: "+templist);
			backtrack(list, templist, n, k, i + 1);
			templist.remove(templist.size() - 1);
			System.out.println("remove tempList: "+templist);
		}
	}
}
