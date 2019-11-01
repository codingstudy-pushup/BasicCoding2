package ama_onsi;

//Input: 153
//Output: true
//Explanation: 
//153 is a 3-digit number, and 153 = 1^3 + 5^3 + 3^3.
public class Armstrong {

	public static void main(String[] args) {
		int a = 153;
		System.out.println(isArmstrong(a));
	}

	public static boolean isArmstrong(int N) {
		String str = String.valueOf(N);
		int n = str.length();
		int curr = 0;
		for (char c : str.toCharArray()) {
			System.out.println("c "+c);
			curr += (int) Math.pow(c - '0', n);
		}
		return curr == N;
	}
}
