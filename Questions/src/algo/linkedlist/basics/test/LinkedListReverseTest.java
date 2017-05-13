package algo.linkedlist.basics.test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import common.ListNode;
import algo.linkedlist.basics.LinkedListReverse;

public class LinkedListReverseTest {

	private ListNode list1;
	private ListNode list2;
	private ListNode list3;
	private ListNode list4;

	@Before
	public void setUp() {
		list1 = ListNode.arrayToList(new int[] { 1 });
		list2 = ListNode.arrayToList(new int[] { 1, 5 });
		list3 = ListNode.arrayToList(new int[] { 1, -1, 19 });
		list4 = ListNode
				.arrayToList(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 });
	}

	@Test
	public void test() {
		LinkedListReverse o = new LinkedListReverse();

		Assert.assertTrue(ListNode.listEqual(o.reverse(list1),
				ListNode.arrayToList(new int[] { 1 })));
		Assert.assertTrue(ListNode.listEqual(o.reverse(list2),
				ListNode.arrayToList(new int[] { 5, 1 })));
		Assert.assertTrue(ListNode.listEqual(o.reverse(list3),
				ListNode.arrayToList(new int[] { 19, -1, 1 })));
		Assert.assertTrue(ListNode.listEqual(o.reverse(list4), ListNode
				.arrayToList(new int[] { 0, 9, 8, 7, 6, 5, 4, 3, 2, 1 })));
	}
}