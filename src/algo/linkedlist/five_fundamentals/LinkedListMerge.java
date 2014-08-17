package algo.linkedlist.five_fundamentals;

import cc150.common.ListNode;

public class LinkedListMerge {

	public ListNode merge(ListNode head1, ListNode head2) {
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;
		while (head1 != null && head2 != null) {
			if (head1.val < head2.val) {
				p.next = head1;
				head1 = head1.next;
				p = p.next;
			} else {
				p.next = head2;
				head2 = head2.next;
				p = p.next;
			}
		}
		if (head1 == null) {
			p.next = head2;
		} else {
			p.next = head1;
		}
		return dummy.next;
	}
}
