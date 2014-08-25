package v4cc150.chap2.test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import common.ListNode;

import v4cc150.chap2.Q2_4;

public class Q2_4_Test {

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
		node1 = new ListNode(new int[] { 1 });
		node2 = new ListNode(new int[] { 3 });
		node3 = new ListNode(new int[] { 4 });
		node4 = new ListNode(new int[] { 9, 9, 5 });
		node5 = new ListNode(new int[] { 2, 1 });
		node6 = new ListNode(new int[] { 1, 1, 6 });
		node7 = new ListNode(new int[] { 2 });
		node8 = new ListNode(new int[] { 9, 9, 9, 9 });
		node9 = new ListNode(new int[] { 1, 0, 0, 0, 1 });
	}

	@Test
	public void test() {
		Q2_4 q = new Q2_4();
//		Assert.assertTrue(Common.compareList(q.addList(null, null), null));
		Assert.assertTrue(ListNode.listEqual(q.addList(null, null), null));
//		Assert.assertTrue(Common.compareList(q.addList(null, node2), node2));
		Assert.assertTrue(ListNode.listEqual(q.addList(null, node2), node2));
//		Assert.assertTrue(Common.compareList(q.addList(node2, null), node2));
		Assert.assertTrue(ListNode.listEqual(q.addList(node2, null), node2));
//		Assert.assertTrue(Common.compareList(q.addList(node1, node2), node3));
		Assert.assertTrue(ListNode.listEqual(q.addList(node1, node2), node3));
//		Assert.assertTrue(Common.compareList(q.addList(node4, node5), node6));
		Assert.assertTrue(ListNode.listEqual(q.addList(node4, node5), node6));
//		Assert.assertTrue(Common.compareList(q.addList(node7, node8), node9));
		Assert.assertTrue(ListNode.listEqual(q.addList(node7, node8), node9));
	}
}