package algo.questions;

import java.util.Stack;

public class InfixToPostfix {

	public static void main(String[] args) {
		InfixToPostfix ins = new InfixToPostfix();
		long startTime = System.currentTimeMillis();

		System.out.println("Start Run... ");
		String input;

		input = "3*(42+2)";
		System.out.println(ins.solve(input) + "should be \n3 42 2 + * ");

		input = "333+44*55/66";
		System.out.println(ins.solve(input) + "should be \n333 44 55 * 66 / + ");

		input = "(300+23)*(43-21)/(84+7)";
		System.out.println(ins.solve(input) + "should be \n300 23 + 43 21 - * 84 7 + / ");

		input = "(4+8)*(6-5)/((3-2)*(2+2))";
		System.out.println(ins.solve(input) + "should be \n4 8 + 6 5 - * 3 2 - 2 2 + * / ");

		System.out.print("Total time = ");
		System.out.print((System.currentTimeMillis() - startTime) / 1000.0);
	}

	public String solve(String infix) {
		StringBuilder sb = new StringBuilder();
		// get next operand or non-operand
		// notice that operand is >=1 chars
		int p = 0;
		int len = infix.length();
		Stack<Character> stack = new Stack<Character>();

		while (p != len) {
			if (isDigit(infix.charAt(p))) {
				// if char at p is a digit
				int q = p;
				while (q != len && isDigit(infix.charAt(q))) {
					q++;
				}
				// it is a number in the range [p, q-1]
				sb.append(infix.substring(p, q) + " ");
				p = q;
			} else {
				// if char at p is + - * / or ( )
				char op = infix.charAt(p++);
				if (op == ')') {
					// pop until sees a '('
					while (stack.peek() != '(') {
						sb.append(stack.pop() + " ");
					}
					stack.pop();
				} else if (op == '(' || op == '+' || op == '-') {
					stack.push(op);
				} else {
					// if * or /
					// pop until sees + or - or '('
					while (!stack.isEmpty()) {
						if (stack.peek() == '+' || stack.peek() == '-' || stack.peek() == '(') {
							break;
						}
						sb.append(stack.pop() + " ");
					}
					stack.push(op);
				}
			}
		}
		// reach Eof, pop everything
		while (!stack.isEmpty()) {
			sb.append(stack.pop() + " ");
		}
		return sb.toString();
	}

	private boolean isDigit(char ch) {
		return '0' <= ch && ch <= '9';
	}
}
