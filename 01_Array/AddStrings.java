
public class AddStrings {

	public static void main(String[] args) {
		String nums1 = "123";
		String nums2 = "99";
		System.out.println(new AddStrings().addStrings2(nums1, nums2));
	}

	public String addStrings2(String num1, String num2) {

		StringBuilder result = new StringBuilder();
		int n1 = num1.length() - 1, n2 = num2.length() - 1, carry = 0;

		while (n1 >= 0 || n2 >= 0 || carry > 0) {
			System.out.println("n1: "+n1+" n2: "+n2);
			int digit1 = (n1 >= 0) ? num1.charAt(n1) - '0' : 0;
			int digit2 = (n2 >= 0) ? num2.charAt(n2) - '0' : 0;

			int sum = digit1 + digit2 + carry;

			result.insert(0, sum % 10);
			carry = sum / 10;

			n1--;
			n2--;
		}
		return result.toString();
	}

	public String addStrings(String num1, String num2) {
		if (num1 == null || num2 == null)
			return null;
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		int l1 = num1.length() - 1;
		int l2 = num2.length() - 1;

		while (l1 >= 0 || l2 >= 0) {
			int n1 = l1 >= 0 ? num1.charAt(l1) - '0' : 0;
			int n2 = l2 >= 0 ? num2.charAt(l2) - '0' : 0;
			int sum = n1 + n2 + carry;
			carry = sum > 9 ? 1 : 0;
			sb.insert(0, sum % 10);
			l1--;
			l2--;
		}

		if (carry == 1)
			sb.insert(0, 1);

		return sb.toString();
	}
}
