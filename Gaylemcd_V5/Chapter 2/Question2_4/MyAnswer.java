package Question2_4;

import CtCILibrary.LinkedListNode;

public class MyAnswer {

	public static LinkedListNode partition(LinkedListNode node, int x) {
		if (node == null) {
			return null;
		}
		LinkedListNode dummy1 = new LinkedListNode();
		LinkedListNode dummy2 = new LinkedListNode();
		LinkedListNode p1 = dummy1;
		LinkedListNode p2 = dummy2;
		while (node != null) {
			if (node.data < x) {
				p1.next = node;
				p1 = node;
			} else {
				p2.next = node;
				p2 = node;
			}
			node = node.next;
		}
		if (dummy1.next == null) {
			return dummy2.next;
		} else {
			p1.next = dummy2.next;
			p2.next = null;
			return dummy1.next;
		}
	}

	public static void main(String[] args) {
		int length = 20;
		LinkedListNode[] nodes = new LinkedListNode[length];
		for (int i = 0; i < length; i++) {
			nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i,
					null, null);
		}

		for (int i = 0; i < length; i++) {
			if (i < length - 1) {
				nodes[i].setNext(nodes[i + 1]);
			}
			if (i > 0) {
				nodes[i].setPrevious(nodes[i - 1]);
			}
		}

		LinkedListNode head = nodes[0];
		System.out.println(head.printForward());

		LinkedListNode h = partition(head, 7);
		System.out.println(h.printForward());
	}

}
