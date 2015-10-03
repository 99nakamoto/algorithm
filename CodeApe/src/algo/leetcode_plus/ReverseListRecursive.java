package algo.leetcode_plus;

import common.ListNode;

public class ReverseListRecursive {

	public static void main(String[] args) {
		ReverseListRecursive ins = new ReverseListRecursive();
		long startTime = System.currentTimeMillis();

		System.out.println("Start Run... ");

		ListNode head = ListNode.arrayToList(new int[] { 1, 3, 5, 7, 2, 4, 6, 8 });
		System.out.println("Input: ");
		ListNode.printList(head);

		ListNode result = ins.reverseRecursively(head);
		System.out.println("Output:");
		ListNode.printList(result);

		System.out.print("Total time = ");
		System.out.print((System.currentTimeMillis() - startTime) / 1000.0);
	}

	public ListNode reverseRecursively(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode temp = head.next;
		// temp is not NULL
		ListNode newHead = reverseRecursively(temp);
		temp.next = head;
		head.next = null;
		return newHead;
	}
}
