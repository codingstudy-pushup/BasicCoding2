package Dp;


public class Fibo_memo {

	public static void main(String[] args) {
		Fibo_memo a = new Fibo_memo();
		int n = 7;
		for (int i = 1; i <= n; i++) {
			System.out.println("1_호출전 i: " + i + " value : " + a.fibonacci(i));
		}
	}


	public int fibonacci(int n) {
		int[] bottomUp = new int[1000];
		System.out.println("2_fibonacci 호출 :" + n);
		
		bottomUp[1] =1;
		bottomUp[2] =1;
		
		for(int i=3; i<=n; i++) {
			bottomUp[i] = bottomUp[i-1] + bottomUp[i-2];
		}
		return bottomUp[n];
	}

}
