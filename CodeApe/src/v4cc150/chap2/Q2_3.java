package v4cc150.chap2;

import common.ListNode;

public class Q2_3 {

	// Implement an algorithm to delete a node in the middle of a single linked
	// list, given only access to that node.
	//
	// EXAMPLE
	// Input: the node 'c' from the linked list a->b->c->d->e
	// Result: nothing is returned, but the new linked list looks like
	// a->b->d->e

	// Difficulty level: 1
	// Time Spend: 3 minute

	public void removeFromMid(ListNode node) {
		if (node == null || node.next == null) {
			// invalid case
			return;
		}
		node.val = node.next.val;
		node.next = node.next.next;
	}
}