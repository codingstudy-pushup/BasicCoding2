package ama_onsi;

import java.util.*;

public class NumSubmatrixSumTarget {

	public static void main(String[] args) {
		int[][] A = { { 0, 1, 0 }, { 1, 1, 1 }, { 0, 1, 0 } };
		int target = 0;
		System.out.println(numSubmatrixSumTarget(A, target));
	}

	public static int numSubmatrixSumTarget(int[][] A, int target) {
		int m = A.length, n = A[0].length;
		for (int i = 0; i < m; i++)
			for (int j = 1; j < n; j++)
				A[i][j] += A[i][j - 1];
		int res = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				Map<Integer, Integer> counter = new HashMap<>();
				counter.put(0, 1);
				int cur = 0;
				for (int k = 0; k < m; k++) {
					cur += A[k][j] - (i > 0 ? A[k][i - 1] : 0);
					res += counter.getOrDefault(cur - target, 0);
					counter.put(cur, counter.getOrDefault(cur, 0) + 1);
				}
			}
		}
		return res;
	}

}
