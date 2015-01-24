package algo.questions;

import java.util.Stack;

import common.Common;

public class ReverseAStack {

	public static void main(String[] args) {
		ReverseAStack ins = new ReverseAStack();

		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 1; i < 5; i++) {
			stack.push(i);
		}
		Common.printList(stack);

		System.out.println("Now, reverse it... ");
		ins.reverse(stack);
		Common.printList(stack);
	}

	public void reverse(Stack<Integer> stack) {
		if (stack.isEmpty() || stack.size() == 1) {
			return;
		}
		int top = stack.pop();
		this.reverse(stack);
		this.insertAtBottom(stack, top);
	}

	private void insertAtBottom(Stack<Integer> stack, int val) {
		if (stack.isEmpty()) {
			stack.push(val);
			return;
		}
		int temp = stack.pop();
		this.insertAtBottom(stack, val);
		stack.push(temp);
	}
}
