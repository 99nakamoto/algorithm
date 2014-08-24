package v4cc150.chap3.test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import v4cc150.chap3.Q3_6;
import cc150.common.MyStack;

public class Q3_6_Test {

	private MyStack s1;
	private MyStack s2;
	private MyStack s3;
	private MyStack s4;
	private MyStack s5;
	private MyStack s6;
	private MyStack s7;
	private MyStack s8;

	@Before
	public void setUp() {
		s1 = new MyStack(new int[] { 1 });
		s2 = new MyStack(new int[] { 1 });
		s3 = new MyStack(new int[] { 1, 5 });
		s4 = new MyStack(new int[] { 1, 5 });
		s5 = new MyStack(new int[] { 14, 9 });
		s6 = new MyStack(new int[] { 9, 14 });
		s7 = new MyStack(new int[] { 1, 5, 4, 9, 10, 3, 8, 2, 7, 6 });
		s8 = new MyStack(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
	}

	@Test
	public void test() {
		Q3_6 q = new Q3_6();
		q.solve(s1);
		Assert.assertTrue(MyStack.stackEqual(s1, s2));
		q.solve(s3);
		Assert.assertTrue(MyStack.stackEqual(s3, s4));
		q.solve(s5);
		Assert.assertTrue(MyStack.stackEqual(s5, s6));
		q.solve(s7);
		Assert.assertTrue(MyStack.stackEqual(s7, s8));
	}
}