package ama001;

import java.util.*;

public class A039_BasicCalculator3 {

	public static void main(String[] args) {
		String s = "2*(5+5*2)/3+(6/2+8)";
		A039_BasicCalculator3 a = new A039_BasicCalculator3();
		System.out.println(a.calculate_deque(s));
	}

	public int calculate_deque(String s) {
		Deque<Integer> operands = new ArrayDeque<>();
		Deque<Character> operators = new ArrayDeque<>();
		int n = s.length();
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			System.out.println("c: "+c);
			if (Character.isDigit(c)) {
				int val = Character.getNumericValue(s.charAt(i));
				while (i + 1 < n && Character.isDigit(s.charAt(i + 1))) {
					val = val * 10 + Character.getNumericValue(s.charAt(i + 1));
					i++;
				}
				operands.push(val);
			} else if (c == ' ') {
				continue;
			} else if (c == '(') {
				operators.push(c);
			} else if (c == ')') {
				while (operators.peek() != '(') {
					operands.push(operate(operands, operators));
				}
				operators.pop();
			} else {
				while (!operators.isEmpty() && comparePrecedence(c, operators.peek()) <= 0) {
					operands.push(operate(operands, operators));
				}
				operators.push(c);
			}
		}

		while (!operators.isEmpty()) {
			operands.push(operate(operands, operators));
		}

		return operands.pop();
	}

	private int comparePrecedence(char a, char b) {
		Map<Character, Integer> map = new HashMap<>();
		map.put('(', -1);
		map.put('+', 0);
		map.put('-', 0);
		map.put('*', 1);
		map.put('/', 1);
		return map.get(a) - map.get(b);
	}

	private int operate(Deque<Integer> operands, Deque<Character> operators) {
		int a = operands.pop();
		int b = operands.pop();
		char c = operators.pop();

		switch (c) {
		case '+':
			return a + b;
		case '-':
			return b - a;
		case '*':
			return a * b;
		case '/':
			return b / a;
		default:
			return 0;
		}
	}

	public static int calculate(String s) {
		if (s == null || s.length() == 0)
			return 0;
		Stack<Integer> nums = new Stack<>(); // the stack that stores numbers
		Stack<Character> ops = new Stack<>(); // the stack that stores operators (including parentheses)
		int num = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			System.out.println("c: " + c);
			if (c == ' ')
				continue;
			if (Character.isDigit(c)) {
				num = c - '0';
				// iteratively calculate each number
				while (i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))) {
					num = num * 10 + (s.charAt(i + 1) - '0');
					i++;
				}
				nums.push(num);
				num = 0; // reset the number to 0 before next calculation
			} else if (c == '(') {
				ops.push(c);
			} else if (c == ')') {
				// do the math when we encounter a ')' until '('
				while (ops.peek() != '(')
					nums.push(operation(ops.pop(), nums.pop(), nums.pop()));
				ops.pop(); // get rid of '(' in the ops stack
			} else if (c == '+' || c == '-' || c == '*' || c == '/') {
				while (!ops.isEmpty() && precedence(c, ops.peek()))
					nums.push(operation(ops.pop(), nums.pop(), nums.pop()));
				ops.push(c);
			}
		}
		while (!ops.isEmpty()) {
			nums.push(operation(ops.pop(), nums.pop(), nums.pop()));
		}
		return nums.pop();
	}

	private static int operation(char op, int b, int a) {
		switch (op) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			return a / b; // assume b is not 0
		}
		return 0;
	}

	// helper function to check precedence of current operator and the uppermost
	// operator in the ops stack
	private static boolean precedence(char op1, char op2) {
		if (op2 == '(' || op2 == ')')
			return false;
		if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
			return false;
		return true;
	}
}
