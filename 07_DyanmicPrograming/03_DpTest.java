package Dp;

public class Dp02 {

	public static void main(String[] args) {
//		String s = "2";
//		String s = "08";
//		String s = "12";
//		String s = "121";
		String s = "129";
//		String s = "226";
//		String s = "326";
//		String s = "30";
//		String s = "365";
//		String s = "3621";
//		String s = "1211";
//		String s = "36111";
//		String s = "12115";
//		String s = "12624";
//		
//		String s = "126";
//		String s = "236";
		Dp02 a = new Dp02();
		System.out.println(a.numDecodings(s));
	}

	public int numDecodings(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int n = s.length();
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = s.charAt(0) == '0' ? 0 : 1;
		for (int i = 2; i <= n; i++) {
			int first = Integer.valueOf(s.substring(i - 1, i));
			int second = Integer.valueOf(s.substring(i - 2, i));

			System.out.println("i "+i+" first: " + first + " second " + second);
			if (first >= 1 && first <= 9) {
				dp[i] += dp[i - 1];
//				dp[i] = dp[i] +dp[i - 1];

			}
			if (second >= 10 && second <= 26) {
//				dp[i] = dp[i] + dp[i - 2];
				dp[i] += dp[i - 2];
			}
		}
		print(dp);
		return dp[n];
	}

	public void print(int[] dp) {

		for (int i : dp)
			System.out.println("result " + i);

	}
	
}
