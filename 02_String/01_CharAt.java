package string;

public class Test_CharAt01 {

	public static void main(String[] args) {
		
		String str1 ="123";
		String str2 ="888";
		System.out.println(new Test_CharAt01().solve(str1, str2));
	}

	public String solve(String num1, String num2) {
		int carry = 0;
		int i = num1.length() - 1, j = num2.length() - 1;
		StringBuilder sb = new StringBuilder();
		while (i >= 0 || j >= 0) {
			int n1 = 0, n2 = 0;
			if (i >= 0) {
				n1 = num1.charAt(i) - '0';
			}
			if (j >= 0) {
				n2 = num2.charAt(j) - '0';
			}
			int sum = n1 + n2 + carry;
			carry = sum / 10;
			sb.append(sum % 10);
			i--;
			j--;
		}

		if (carry != 0) {
			sb.append(carry);
		}

		return sb.reverse().toString();
	}

}
