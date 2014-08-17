package algo.linkedlist.five_fundamentals.test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import algo.linkedlist.five_fundamentals.LinkedListFindMid;
import cc150.common.ListNode;

public class LinkedListFindMidTest {

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
		LinkedListFindMid o = new LinkedListFindMid();

		Assert.assertEquals(o.findMiddle(list1), null);
		Assert.assertEquals(o.findMiddle(list2).val, -1);
		Assert.assertEquals(o.findMiddle(list3).val, -1);
		Assert.assertEquals(o.findMiddle(list4).val, 2);
		Assert.assertEquals(o.findMiddle(list5).val, 1);
	}
}