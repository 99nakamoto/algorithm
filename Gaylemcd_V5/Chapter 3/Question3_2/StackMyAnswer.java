package Question3_2;

import java.util.Stack;

public class StackMyAnswer extends Stack<Integer> {

	Stack<Integer> min = new Stack<Integer>();

	public void push(int value) {
		if (min.isEmpty() || value <= min.peek()) {
			min.push(value);
		}
		super.push(value);
	}

	public Integer pop() {
		int val = super.pop();
		if (!min.isEmpty() && val == min.peek()) {
			min.pop();
		}
		return val;
	}

	public int min() {
		if (min.isEmpty()) {
			return Integer.MAX_VALUE;
		}
		return min.peek();
	}
}
