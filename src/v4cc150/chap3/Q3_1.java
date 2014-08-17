package v4cc150.chap3;

public class Q3_1 {

	// Describe how you could use a single array to implement three stacks.

	// Difficulty level: 5
	// Time Spend:

	// Normally stack is implemented using LinkedList
	// In this question, we can make the array dynamically-resizing
	// and we keep 4 pointers to keep track of stack begin and end

	int[] arr;

	public Q3_1() {
		this(6);
	}

	public Q3_1(int size) {
		arr = new int[size];
	}

	public void push(int stack, int val) {

	}

	public int peek(int stack) {
		return 0;
	}

	public int pop(int stack) {
		return 0;
	}

	public boolean isEmpty(int stack) {
		return true;
	}
}