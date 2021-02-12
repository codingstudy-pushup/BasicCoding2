package Stack_Queue;

import java.util.*;

public class Stack02 {

	public static void main(String[] args) {
		String s = "12[a]2[bc]2[d]";
		Stack02 a = new Stack02();
		System.out.println(a.solve(s));
	}

	String solve(String s) {
		Stack<Integer> countStack = new Stack<>();
		Stack<StringBuilder> stringStack = new Stack<>();
		StringBuilder result = new StringBuilder();
		int k = 0;
		for (char ch : s.toCharArray()) {
			System.out.println("ch " + ch);
			if (Character.isDigit(ch)) {
				k = k * 10 + ch - '0';
			} else if (ch == '[') {

				countStack.push(k);

				System.out.println("result " + result);
				stringStack.push(result);

				result = new StringBuilder();
				k = 0;
			} else if (ch == ']') {
				StringBuilder str = stringStack.pop();
				System.out.println("str " + str);

				for (int currentK = countStack.pop(); currentK > 0; currentK--) {
					str.append(result);
				}
				result = str;
			} else {
				result.append(ch);
			}
		}
		return result.toString();
	}

}
