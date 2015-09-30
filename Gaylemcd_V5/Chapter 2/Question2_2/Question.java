package Question2_2;

import CtCILibrary.*;

public class Question {

	public static int nthToLastRecursive(LinkedListNode head, int n) {
		if (n == 0 || head == null) {
			return 0;
		}
		int k = nthToLastRecursive(head.next, n) + 1;
		if (k == n) {
			System.out.println(n + "th to last node is " + head.data);
		}
		return k;
	}

	public static int nthToLastMe(LinkedListNode head, int n) {
		// to do
		return 0;
	}

	public static void main(String[] args) {
		LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
		System.out.println(head.printForward());
		
		int nth = 4;
		nthToLastRecursive(head, nth);
		nthToLastMe(head, nth);
	}

}
