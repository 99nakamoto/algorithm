package algo.linkedlist.fundamentals;

import cc150.common.ListNode;

public class LinkedListReverse {

	public ListNode reverse(ListNode head) {
		return null;
	}

	public ListNode reverse2(ListNode head) {
		ListNode newHead = null;
		while (head != null) {
			ListNode temp = head.next;
			head.next = newHead;
			newHead = head;
			head = temp;
		}
		return newHead;
	}
}
