package algo.lowlevel;

public class MyStack {

	Node top;

	public MyStack() {
		top = null;
	}

	public int pop() {
		if (top == null) {
			return -1;
		}
		int returnVal = top.val;
		top = top.next;
		return returnVal;
	}

	public int peek() {
		if (top == null) {
			return -1;
		}
		return top.val;

	}

	public void push(int val) {
		Node newNode = new Node(val);
		newNode.next = top;
		top = newNode;
	}

	class Node {

		int val;
		Node next;

		Node(int value) {
			val = value;
		}
	}

	public static void main(String[] args) {
		MyStack stack = new MyStack();

		// push some data
		for (int i = 0; i < 10; i++) {
			stack.push(i * 11);
		}
		for (int i = 0; i < 10; i++) {
			stack.push((int) Math.pow(2, i));
		}

		// pop some data
		for (int i = 0; i < 22; i++) {
			System.out.print(stack.pop() + " ");
			if (i % 10 == 9)
				System.out.println();
		}
	}
}
