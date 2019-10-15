package ama001;

public class A005_LongestPalindromSubstring {

	public static void main(String[] args) {
		A005_LongestPalindromSubstring a = new A005_LongestPalindromSubstring();
		String s = "bananas";
		System.out.println(a.longestPalindrome_dp(s));

		System.out.println(a.LPS(s));
	}

	public static String LPS(String s) {
		int n = s.length();
		int palindromeBeginsAt = 0; // index where the longest palindrome begins
		int max_len = 1;// length of the longest palindrome
		boolean palindrome[][] = new boolean[n][n]; // boolean table to store palindrome truth

		// Trivial case: single letter palindromes
		for (int i = 0; i < n; i++) {
			palindrome[i][i] = true;
		}

		// Finding palindromes of two characters.
		for (int i = 0; i < n - 1; i++) {
//			  System.out.println("i "+i+" i+1 "+(i+1));
//			  System.out.println("s.charAt(i) "+s.charAt(i)+" s.charAt(i+1) "+s.charAt(i+1));
			if (s.charAt(i) == s.charAt(i + 1)) {
				System.out.println("s.charAt(i) " + s.charAt(i) + " s.charAt(i+1) " + s.charAt(i + 1));
				palindrome[i][i + 1] = true;
				palindromeBeginsAt = i;
				max_len = 2;
			}
		}

		// Finding palindromes of length 3 to n and saving the longest
		for (int curr_len = 3; curr_len <= n; curr_len++) {
			for (int i = 0; i < n - curr_len + 1; i++) {
				int j = i + curr_len - 1;
				System.out.println("i " + (i) + " j " + (j));
				if (s.charAt(i) == s.charAt(j) // 1. The first and last characters should match
						&& palindrome[i + 1][j - 1]) // 2. Rest of the substring should be a palindrome
				{
					System.out.println("i+1 " + (i + 1) + " j+1 " + (j + 1));
					palindrome[i][j] = true;
					palindromeBeginsAt = i;
					max_len = curr_len;
				}
			}
		}
		System.out.println(palindromeBeginsAt + "  " + (max_len + palindromeBeginsAt));
		return s.substring(palindromeBeginsAt, max_len + palindromeBeginsAt);
	}

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

		return res;
	}

	private int lo, maxLen;

	public String longestPalindrome(String s) {
		int len = s.length();
		if (len < 2)
			return s;

		for (int i = 0; i < len - 1; i++) {
			extendPalindrome(s, i, i); // assume odd length, try to extend Palindrome as possible
			extendPalindrome(s, i, i + 1); // assume even length.
		}
		return s.substring(lo, lo + maxLen);
	}

	private void extendPalindrome(String s, int j, int k) {
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
			j--;
			k++;
		}
		if (maxLen < k - j - 1) {
			lo = j + 1;
			maxLen = k - j - 1;
		}
	}
}
