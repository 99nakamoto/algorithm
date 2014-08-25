package algo.linkedlist.fundamentals;

import cc150.common.ListNode;

public class LinkedListFindMid {

	public ListNode findMiddle(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode slow = head, fast = head.next;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
}
