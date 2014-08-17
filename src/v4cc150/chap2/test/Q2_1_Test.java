package v4cc150.chap2.test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import v4cc150.chap2.Q2_1;
import cc150.common.ListNode;

public class Q2_1_Test {

	private ListNode node0;
	private ListNode node1;
	private ListNode node2;
	private ListNode node3;
	private ListNode node4;
	private ListNode node5;
	private ListNode node6;
	private ListNode node7;
	private ListNode node8;
	private ListNode node9;

	@Before
	public void setUp() {
		node0 = null;
		node1 = new ListNode(new int[] { 1 });
		node2 = new ListNode(new int[] { 1 });
		node3 = new ListNode(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 });
		node4 = new ListNode(new int[] { 1, 8, 4, 67, 34, 55, 235, 6, 3, 455,
				35, 9807, 88, 710, 73 });
		node5 = new ListNode(new int[] { 1, 8, 4, 67, 34, 55, 235, 6, 3, 455,
				35, 9807, 88, 710, 73 });
		node6 = new ListNode(new int[] { 1, 8, 4, 1, 67, 34, 55, 8, 235, 6, 3,
				455, 35, 9807, 88, 88, 1, 710, 73, 4 });
		node7 = new ListNode(new int[] { 1, 3, 3, 3, 3, 3 });
		node8 = new ListNode(new int[] { 1, 1, 1, 1, 1, 1, 3 });
		node9 = new ListNode(new int[] { 1, 3 });
	}

	@Test
	public void test() {
		Q2_1 q = new Q2_1();
		q.removeDup(node0);
		// Assert.assertTrue(Common.compareList(node0, null));
		Assert.assertTrue(ListNode.listEqual(node0, null));
		q.removeDup(node2);
		q.removeDup(node3);
		// Assert.assertTrue(Common.compareList(node1, node2));
		Assert.assertTrue(ListNode.listEqual(node1, node2));
		// Assert.assertTrue(Common.compareList(node1, node3));
		Assert.assertTrue(ListNode.listEqual(node1, node3));
		q.removeDup(node4);
		// Assert.assertTrue(Common.compareList(node4, node5));
		Assert.assertTrue(ListNode.listEqual(node4, node5));
		q.removeDup(node6);
		// Assert.assertTrue(Common.compareList(node6, node5));
		Assert.assertTrue(ListNode.listEqual(node6, node5));
		q.removeDup(node7);
		q.removeDup(node8);
		// Assert.assertTrue(Common.compareList(node7, node9));
		Assert.assertTrue(ListNode.listEqual(node7, node9));
		// Assert.assertTrue(Common.compareList(node8, node9));
		Assert.assertTrue(ListNode.listEqual(node8, node9));
	}
}