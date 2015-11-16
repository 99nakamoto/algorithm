package algo.questions;

import java.util.Stack;

public class InfixToPostfix {

	public static void main(String[] args) {
		InfixToPostfix ins = new InfixToPostfix();
		long startTime = System.currentTimeMillis();

		System.out.println("Start Run... ");
		String input;

		input = "a*b+2";
		System.out.println(ins.solve(input));

		System.out.print("Total time = ");
		System.out.print((System.currentTimeMillis() - startTime) / 1000.0);
	}

	public String solve(String infix) {
		Stack<Character> st1 = new Stack<Character>();
		Stack<String> st2 = new Stack<String>();
		
		
		return null;
	}
}
