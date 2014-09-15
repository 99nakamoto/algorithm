package algo.linkedlist.basics.test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import common.ListNode;
import algo.linkedlist.basics.LinkedListRemove;

public class LinkedListRemoveTest {

	private ListNode list1;

	@Before
	public void setUp() {
		list1 = ListNode.arrayToList(new int[] { -1, 1, 2, 2, 2, 3, 3 });
	}

	@Test
	public void test() {
		LinkedListRemove o = new LinkedListRemove();

		list1 = o.remove(list1, 2);
		Assert.assertTrue(ListNode.listEqual(list1,
				ListNode.arrayToList(new int[] { -1, 1, 3, 3 })));

		list1 = o.remove(list1, 3);
		Assert.assertTrue(ListNode.listEqual(list1,
				ListNode.arrayToList(new int[] { -1, 1 })));

		list1 = o.remove(list1, 3);
		Assert.assertTrue(ListNode.listEqual(list1,
				ListNode.arrayToList(new int[] { -1, 1 })));

		list1 = o.remove(list1, -1);
		Assert.assertTrue(ListNode.listEqual(list1,
				ListNode.arrayToList(new int[] { 1 })));

		list1 = o.remove(list1, 1);
		Assert.assertTrue(ListNode.listEqual(list1, null));
	}
}