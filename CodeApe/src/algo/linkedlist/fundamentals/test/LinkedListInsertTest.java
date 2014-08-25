package algo.linkedlist.fundamentals.test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import algo.linkedlist.fundamentals.LinkedListInsert;
import cc150.common.ListNode;

public class LinkedListInsertTest {

	private ListNode list1;
	private ListNode list2;
	private ListNode list3;
	private ListNode list4;
	private ListNode list5;

	@Before
	public void setUp() {
		list1 = ListNode.arrayToList(null);
		list2 = ListNode.arrayToList(new int[] { -1 });
		list3 = ListNode.arrayToList(new int[] { -1, 2 });
		list4 = ListNode.arrayToList(new int[] { -1, 2, 3 });
		list5 = ListNode.arrayToList(new int[] { -1, 1, 2, 3 });
	}

	@Test
	public void test() {
		LinkedListInsert o = new LinkedListInsert();

		Assert.assertTrue(ListNode.listEqual(list2,
				o.insert(list1, new ListNode(-1))));
		Assert.assertTrue(ListNode.listEqual(list3,
				o.insert(list2, new ListNode(2))));
		Assert.assertTrue(ListNode.listEqual(list4,
				o.insert(list3, new ListNode(3))));
		Assert.assertTrue(ListNode.listEqual(list5,
				o.insert(list4, new ListNode(1))));
		Assert.assertFalse(ListNode.listEqual(list5,
				o.insert(list4, new ListNode(1))));
	}
}