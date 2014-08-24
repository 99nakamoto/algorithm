package v4cc150.chap2;

import java.util.HashSet;

import cc150.common.ListNode;

public class Q2_1 {

	// Write code to remove duplicates from an unsorted linked list.
	// FOLLOW UP
	// How would you solve this problem if a temporary buffer is not allowed?

	// Difficulty level: 3
	// Time Spend: long time, due to many reasons

	public void removeDup(ListNode node) {
		if (node == null || node.next == null) {
			return;
		}
		ListNode p = node;
		ListNode runner = null;
		while (p != null && p.next != null) {
			runner = node;
			while (true) {
				if (runner.val == p.next.val) {
					// if found dup node in front of p
					p.next = p.next.next;
					break;
				}
				if (runner == p) {
					p = p.next;
					break;
				} else {
					runner = runner.next;
				}
			}
		}
	}

	public void removeDup2(ListNode head) {
		// use additional buffer
		if (head == null || head.next == null) {
			return;
		}
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(head.val);
		ListNode p = head;
		while (p.next != null) {
			if (set.contains(p.next.val)) {
				p.next = p.next.next;
			} else {
				set.add(p.next.val);
				p = p.next;
			}
		}
	}
}