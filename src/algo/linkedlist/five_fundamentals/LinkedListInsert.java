package algo.linkedlist.five_fundamentals;

import cc150.common.ListNode;

public class LinkedListInsert {

	public ListNode insert(ListNode head, ListNode node) {
		// first, initialize
		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		dummy.next = head;

		// second, assume p is less than node, and check p.next
		ListNode p = dummy;
		while (p.next != null && p.next.val < node.val) {
			p = p.next;
		}

		// insert node after 'p'
		node.next = p.next;
		p.next = node;
		return dummy.next;
	}
}
