package Dp;

import java.util.HashMap;
import java.util.Map;

public class Fibo_bottomUp {

	public static void main(String[] args) {
		Fibo_bottomUp a = new Fibo_bottomUp();
		int n = 7;
		for (int i = 1; i <= n; i++) {
			System.out.println("1_호출전 i: " + i + " value : " + a.fibonacci(i));
		}
	}

	int[] memo = new int[1000];

	public int fibonacci(int n) {

		System.out.println("2_fibonacci 호출 :" + n);
		if (n <= 1) {
			return n;
		} else if (memo[n] != 0) {
			System.out.println("3_fibonacci 호출 :" + memo[n]);
			return memo[n];
		} else {

			return memo[n] = fibonacci(n - 2) + fibonacci(n - 1);
		}
	}

}
