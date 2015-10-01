package Question2_7;

import java.util.Stack;

import CtCILibrary.LinkedListNode;

public class MyAnswer {

	public static boolean isPalindromeStack(LinkedListNode head) {
		int len = getListLength(head);
		int half = len / 2;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < half; i++) {
			stack.push(head.data);
			head = head.next;
		}
		if (len % 2 == 1) {
			head = head.next;
		}
		for (int i = 0; i < half; i++) {
			if (head.data != stack.pop()) {
				return false;
			}
			head = head.next;
		}
		return true;
	}

	private static LinkedListNode p;

	public static boolean isPalindromeRecursive(LinkedListNode head) {
		p = head;
		int len = getListLength(head);
		return recursiveHelper(0, len - 1);
	}

	private static int getListLength(LinkedListNode node) {
		int count = 0;
		while (node != null) {
			count++;
			node = node.next;
		}
		return count;
	}

	public static boolean recursiveHelper(int from, int to) {
		if (from > to) {
			return true;
		} else if (from == to) {
			p = p.next;
			return true;
		} else {
			// first get fromVal, then check middle part, last, get toVal
			int fromVal = p.data;
			p = p.next;
			if (!recursiveHelper(from + 1, to - 1)) {
				return false;
			}
			int toVal = p.data;
			p = p.next;
			if (fromVal != toVal) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		System.out.println("My answer");

		int length = 10;
		LinkedListNode[] nodes = new LinkedListNode[length];
		for (int i = 0; i < length; i++) {
			nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i, null, null);
		}

		for (int i = 0; i < length; i++) {
			if (i < length - 1) {
				nodes[i].setNext(nodes[i + 1]);
			}
			if (i > 0) {
				nodes[i].setPrevious(nodes[i - 1]);
			}
		}
		// nodes[length - 2].data = 9; // Uncomment to ruin palindrome

		LinkedListNode head = nodes[0];
		System.out.println(head.printForward());
		System.out.println(isPalindromeStack(head) + " " + isPalindromeRecursive(head));

		length = 9;
		nodes = new LinkedListNode[length];
		for (int i = 0; i < length; i++) {
			nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i, null, null);
		}

		for (int i = 0; i < length; i++) {
			if (i < length - 1) {
				nodes[i].setNext(nodes[i + 1]);
			}
			if (i > 0) {
				nodes[i].setPrevious(nodes[i - 1]);
			}
		}
		// nodes[length - 2].data = 9; // Uncomment to ruin palindrome

		head = nodes[0];
		System.out.println(head.printForward());
		System.out.println(isPalindromeStack(head) + " " + isPalindromeRecursive(head));

		nodes[3].data = 4;
		System.out.println(head.printForward());
		System.out.println(isPalindromeStack(head) + " " + isPalindromeRecursive(head));

	}
}
