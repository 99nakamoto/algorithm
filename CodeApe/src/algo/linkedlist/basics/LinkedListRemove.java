package algo.linkedlist.basics;

import common.ListNode;

public class LinkedListRemove {

	public ListNode remove(ListNode head, int value) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode p = dummy;
		while (p.next != null && p.next.val != value) {
			p = p.next;
		}
		if (p.next != null && p.next.val == value) {
			while (p.next != null && p.next.val == value)
				p.next = p.next.next;
		}
		return dummy.next;
	}
}
