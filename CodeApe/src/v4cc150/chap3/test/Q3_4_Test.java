package v4cc150.chap3.test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import common.MyStack;

import v4cc150.chap3.Q3_4;

public class Q3_4_Test {

	private MyStack stack1;
	private MyStack stack2;
	private MyStack stack3;

	@Before
	public void setUp() {
		// I really should write a stack myself
		stack1 = new MyStack(new int[] { 16, 15, 14, 13, 12, 11 });
		stack2 = new MyStack();
		stack3 = new MyStack();
	}

	@Test
	public void test() {
		Q3_4 q = new Q3_4();
		q.solve(stack1, stack2, stack3);
		Assert.assertTrue(MyStack.stackEqual(stack1, null));
		Assert.assertTrue(MyStack.stackEqual(stack2, null));
		MyStack tempStack = new MyStack(new int[] { 16, 15, 14, 13, 12, 11 });
		Assert.assertTrue(MyStack.stackEqual(stack3, tempStack));
	}
}
