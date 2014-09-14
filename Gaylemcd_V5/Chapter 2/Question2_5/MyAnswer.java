package Question2_5;

import CtCILibrary.LinkedListNode;

public class MyAnswer {

	private static PartialSum addLists(LinkedListNode l1, LinkedListNode l2) {
		// assume l1 and l2 are same length
		int sum = l1.data + l2.data;
		PartialSum curSum = new PartialSum();
		if (l1 == null && l2 == null) {
			curSum.sum = null;
			curSum.carry = 0;
		} else {
			curSum.sum = new LinkedListNode(sum % 10, null, null);
			curSum.carry = sum / 10;
		}
		return null;
	}

	public static int linkedListToInt(LinkedListNode node) {
		int value = 0;
		while (node != null) {
			value = value * 10 + node.data;
			node = node.next;
		}
		return value;
	}

	public static void main(String[] args) {
		LinkedListNode lA1 = new LinkedListNode(3, null, null);
		LinkedListNode lA2 = new LinkedListNode(1, null, lA1);
		LinkedListNode lA3 = new LinkedListNode(5, null, lA2);

		LinkedListNode lB1 = new LinkedListNode(5, null, null);
		LinkedListNode lB2 = new LinkedListNode(9, null, lB1);
		LinkedListNode lB3 = new LinkedListNode(1, null, lB2);

		LinkedListNode list3 = addLists(lA1, lB1).sum;

		System.out.println("  " + lA1.printForward());
		System.out.println("+ " + lB1.printForward());
		System.out.println("= " + list3.printForward());

		int l1 = linkedListToInt(lA1);
		int l2 = linkedListToInt(lB1);
		int l3 = linkedListToInt(list3);

		System.out.print(l1 + " + " + l2 + " = " + l3 + "\n");
		System.out.print(l1 + " + " + l2 + " = " + (l1 + l2));
	}
}
