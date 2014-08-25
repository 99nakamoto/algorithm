package algo.linkedlist.fundamentals.test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import algo.linkedlist.fundamentals.LinkedListMerge;
import cc150.common.ListNode;

public class LinkedListMergeTest {

	private ListNode list1;
	private ListNode list2;
	private ListNode list3;
	private ListNode list4;
	private ListNode list5;
	private ListNode list6;
	private ListNode list7;
	private ListNode list8;

	@Before
	public void setUp() {
		list1 = ListNode.arrayToList(null);
		list2 = ListNode.arrayToList(new int[] { -1 });
		list3 = ListNode.arrayToList(new int[] { 1 });
		list4 = ListNode.arrayToList(new int[] { -1, 2 });
		list5 = ListNode.arrayToList(new int[] { -1, 2, 3 });
		list6 = ListNode.arrayToList(new int[] { 14, 15 });
		list7 = ListNode.arrayToList(new int[] { 23, 55, 100 });
		list8 = ListNode.arrayToList(new int[] { -15, -14 });
	}

	@Test
	public void test() {
		LinkedListMerge o = new LinkedListMerge();

		Assert.assertTrue(ListNode.listEqual(o.merge(list1, list2),
				ListNode.arrayToList(new int[] { -1 })));
		Assert.assertTrue(ListNode.listEqual(o.merge(list3, list4),
				ListNode.arrayToList(new int[] { -1, 1, 2 })));
		Assert.assertFalse(ListNode.listEqual(o.merge(list3, list4),
				ListNode.arrayToList(new int[] { -1, 2, 1 })));
		Assert.assertTrue(ListNode.listEqual(o.merge(list5, list6),
				ListNode.arrayToList(new int[] { -1, 2, 3, 14, 15 })));
		Assert.assertTrue(ListNode.listEqual(o.merge(list7, list8),
				ListNode.arrayToList(new int[] { -15, -14, 23, 55, 100 })));
	}
}