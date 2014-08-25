package v4cc150.chap2.test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import common.ListNode;

import v4cc150.chap2.Q2_3;

public class Q2_3_Test {

	private ListNode node1;
	private ListNode node2;
	private ListNode node3;
	private ListNode node4;

	@Before
	public void setUp() {
		node1 = new ListNode(new int[] { 1, 4, 3, 7, 2, 40, 21 });
		node2 = new ListNode(new int[] { 555, 1, 4, 3, 7, 2, 40, 21 });
		node3 = new ListNode(new int[] { 1, 4, 3, 7, 2, 40, 555, 21 });
		node4 = new ListNode(new int[] { 1, 4, 3, 555, 7, 2, 40, 21 });
	}

	@Test
	public void test() {
		Q2_3 q = new Q2_3();
		q.removeFromMid(node2);
		q.removeFromMid(node3.next.next.next.next.next.next);
		q.removeFromMid(node4.next.next.next);
		// Assert.assertTrue(Common.compareList(node1, node2));
		Assert.assertTrue(ListNode.listEqual(node1, node2));
		// Assert.assertTrue(Common.compareList(node1, node3));
		Assert.assertTrue(ListNode.listEqual(node1, node3));
		// Assert.assertTrue(Common.compareList(node1, node4));
		Assert.assertTrue(ListNode.listEqual(node1, node4));
	}
}