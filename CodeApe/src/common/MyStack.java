package common;

public class MyStack {
	Node top;

	public MyStack() {
		top = null;
	}

	public MyStack(int[] arr) {
		// For reuse of constructors, we can only chain to one constructor,
		// and it has to be the first statement in the constructor body.
		// http://stackoverflow.com/a/285184
		this();
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			this.push(arr[i]);
		}
	}

	public Object pop() {
		if (top != null) {
			Object item = top.data;
			top = top.next;
			return item;
		}
		return null;
	}

	public void push(Object item) {
		Node t = new Node(item);
		t.next = top;
		top = t;
	}

	public static boolean stackEqual(MyStack s1, MyStack s2) {
		if (s1 == null && s2 == null)
			return true;
		if (s1 == null || s2 == null)
			return false;
		while (s1 != null) {
			Node n1 = (Node) s1.pop();
			Node n2 = (Node) s2.pop();
			if ((int) n1.data != (int) n2.data) {
				return false;
			}
		}
		return s1 == null;
	}

	class Node {
		Node next = null;
		Object data;

		public Node(Object item) {
			data = item;
		}

		void appendToTail(Object d) {
			Node end = new Node(d);
			Node n = this;
			while (n.next != null) {
				n = n.next;
			}
			n.next = end;
		}
	}
}