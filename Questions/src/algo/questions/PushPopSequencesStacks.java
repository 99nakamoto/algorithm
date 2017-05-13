package algo.questions;

import java.util.Stack;

public class PushPopSequencesStacks {

	public static void main(String[] args) {
		PushPopSequencesStacks ins = new PushPopSequencesStacks();

		int[] input = new int[] { 1, 2, 3, 4, 5 };
		int[] sequenc;

		sequenc = new int[] { 4, 5, 3, 2, 1 };
		System.out.println("Valid sequence? "
				+ ins.validSequence(input, sequenc));

		sequenc = new int[] { 2, 4, 3, 5, 1 };
		System.out.println("Valid sequence? "
				+ ins.validSequence(input, sequenc));

		sequenc = new int[] { 1, 2, 3, 4, 5 };
		System.out.println("Valid sequence? "
				+ ins.validSequence(input, sequenc));

		sequenc = new int[] { 4, 3, 5, 1, 2 };
		System.out.println("Valid sequence? "
				+ ins.validSequence(input, sequenc));
	}

	public boolean validSequence(int[] input, int[] sequenc) {
		// keep a pointer p in the input[] array
		int len = input.length;
		int p = 0;
		Stack<Integer> stack = new Stack<Integer>();

		int i = 0;
		while (i < len) {
			if (stack.isEmpty()) {
				// just push an element to stack
				stack.push(input[p++]);
			} else {
				// stack got elements, then check top one
				if (stack.peek() == sequenc[i]) {
					// seq found, proceed to next number in seq
					stack.pop();
					i++;
				} else {
					// did not find seq, keep pushing to stack until done
					if (p == len) {
						return false;
					} else {
						stack.push(input[p++]);
					}
				}
			}
		}
		return i == len; // or just return true;
	}
}
