package v4cc150.chap3.test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import v4cc150.chap3.Q3_2;

public class Q3_2_Test {

	private Q3_2 stack;

	@Before
	public void setUp() {
		stack = new Q3_2();
	}

	@Test
	public void test() {
		// 4, 7, 2, 34, 5
		stack.push(4);
		stack.push(7);
		stack.push(100);
		stack.pop();
		Assert.assertEquals(stack.peek().val, 7);
		stack.push(2);
		stack.push(34);
		stack.push(5);
		Assert.assertEquals(stack.peek().val, 5);
		Assert.assertEquals(stack.min().val, 2);
		// 4, 7, 99
		stack.pop();
		stack.pop();
		stack.pop();
		stack.push(99);
		Assert.assertEquals(stack.min().val, 4);
	}
}