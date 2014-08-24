package v4cc150.chap2;

import cc150.common.ListNode;

public class Q2_4 {

	// You have two numbers represented by a linked list, where each node
	// contains a single digit. The digits are stored in reverse order, such
	// that last digit is at the head of the list. Write a function that adds
	// the two numbers and returns the sum as a linked list.
	//
	// EXAMPLE
	// Input: (3 -> 1 -> 5) + (5 -> 9 -> 2)
	// Output: 8 -> 0 -> 8
	// this means 513 + 295 = 808

	// [LeetCode 2] Add Two Numbers
	// http://codeaperan.github.io/leetcode/2014/04/27/add-two-numbers/

	// Difficulty level: 4
	// Time Spend: quite a long time (debugging)

	// I was trying to do it in-place, but in fact it's almost impossible

	public ListNode addList(ListNode node1, ListNode node2) {
		ListNode ans = new ListNode(1);
		ListNode p = node1, q = node2, a = ans;
		int carry = 0;
		while (p != null || q != null) {
			int sum = carry;
			if (p != null) {
				sum += p.val;
				p = p.next;
			}
			if (q != null) {
				sum += q.val;
				q = q.next;
			}
			a.next = new ListNode(sum % 10);
			carry = sum / 10;
			a = a.next;
		}
		if (carry == 1) {
			a.next = new ListNode(1);
		}
		return ans.next;
	}
}