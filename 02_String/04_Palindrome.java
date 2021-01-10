public class String_palindrom {

	public static void main(String[] args) {
		String_palindrom a = new String_palindrom();
		String s = "bananas";

		System.out.println(a.solve(s));
//			System.out.println(a.solve(s));
	}
	
	private int start, end;

	public String solve(String s) {
		int len = s.length();
		if (len < 2)
			return s;

		for (int i = 0; i < len - 1; i++) {
			findSubstring(s, i, i, "odd"); //
			findSubstring(s, i, i + 1, "even"); //
		}
		return s.substring(start, start + end);
	}

	private void findSubstring(String s, int left, int right, String str) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		if (end < right - left - 1) {
			start = left + 1;
			end = right - left - 1;
		}
	}
	
	
	
	//2
	public String longestPalindrome_dp(String s) {
		int n = s.length();
		String res = null;

		boolean[][] dp = new boolean[n][n];

		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
				System.out.println("dp[" + i + "][" + j + "] " + dp[i][j]);

				if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
					res = s.substring(i, j + 1);
				}
			}
		}
		print(dp);

		return res;
	}
	public void print(boolean[][] dp) {
		for(int i=0; i<dp.length; i++) {
			for(int j=0; j<dp[i].length; j++) {
				System.out.print(" dp[" + i + "][" + j + "] " + dp[i][j]);
			}
			System.out.println();
		}
	}
