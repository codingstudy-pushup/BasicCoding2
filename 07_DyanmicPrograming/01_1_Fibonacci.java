package Dp;

public class Fibo {

	public static void main(String[] args) {
		int n = 7;
		for (int i = 1; i <= n; i++) {
			System.out.println("호출전 i: "+i+" value : "+fibonacci(i));
		}
	}

	public static int fibonacci(int n) {
		
		System.out.println("fibonacci 호출 :"+n);
		if (n <= 1)
			return n;
		else
			return fibonacci(n - 2) + fibonacci(n - 1);
	}

}
