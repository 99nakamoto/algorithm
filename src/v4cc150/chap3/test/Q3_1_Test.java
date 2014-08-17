package v4cc150.chap3.test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import v4cc150.chap3.Q3_1;

public class Q3_1_Test {

	private Q3_1 stack;
	private Q3_1 stack2;
	private Q3_1 stack3;

	@Before
	public void setUp() {
		stack = new Q3_1();
		stack2 = new Q3_1();
		stack3 = new Q3_1();
	}

	/*
	 * Eq classes:
	 * 
	 * empty stack push, pop, peek, isEmpty
	 * 
	 * non-empty stack push, pop, peek, isEmpty
	 * 
	 * first stack empty, second empty, third empty
	 * 
	 * push beyond array limit
	 */

	@Test
	public void test() {

		// empty stack operations
		Assert.assertTrue(stack.isEmpty(1));
		Assert.assertTrue(stack.isEmpty(2));
		Assert.assertTrue(stack.isEmpty(3));
		stack.push(1, 11);
		Assert.assertFalse(stack.isEmpty(1));
		Assert.assertTrue(stack.isEmpty(2));
		Assert.assertTrue(stack.isEmpty(3));
		stack.pop(2);
		Assert.assertFalse(stack.isEmpty(1));
		Assert.assertTrue(stack.isEmpty(2));
		Assert.assertTrue(stack.isEmpty(3));
		int temp = stack.peek(3);
		Assert.assertEquals(temp, -1);

		// non-empty stack operations
		stack.push(2, 22);
		stack.push(3, 33);
		stack.push(2, 24);
		stack.push(1, 12);
		stack.push(1, 13);
		stack.push(1, 14);
		// 11,12,13,14 | 22,24 | 33
		Assert.assertEquals(stack.peek(1), 14);
		Assert.assertEquals(stack.peek(2), 24);
		Assert.assertEquals(stack.peek(3), 33);

		// pop everything
		for (int i = 1; i <= 3; i++) {
			while (!stack.isEmpty(i)) {
				stack.pop(i);
			}
		}
		Assert.assertTrue(stack.isEmpty(1));
		Assert.assertTrue(stack.isEmpty(2));
		Assert.assertTrue(stack.isEmpty(3));

		// 2nd and 3rd stack push
		stack.push(2, 77);
		Assert.assertEquals(stack.pop(2), 77);
		stack.push(3, 777);
		Assert.assertEquals(stack.pop(3), 777);
	}

	@Test
	public void testLimit() {
		// if I push 15 times, the stack will resize twice
		// 6 -> 12 -> 24
		for (int i = 1; i <= 15; i++) {
			stack2.push(1, i);
		}
		Assert.assertFalse(stack2.isEmpty(1));
		Assert.assertTrue(stack2.isEmpty(2));
		Assert.assertTrue(stack2.isEmpty(3));
		Assert.assertEquals(stack2.peek(1), 15);

		stack3.push(1, 111);
		stack3.push(3, 3333);
		for (int i = 1; i <= 15; i++) {
			stack3.push(2, i);
		}
		Assert.assertFalse(stack3.isEmpty(1));
		Assert.assertFalse(stack3.isEmpty(2));
		Assert.assertFalse(stack3.isEmpty(3));
		Assert.assertEquals(stack3.peek(1), 111);
		Assert.assertEquals(stack3.peek(2), 15);
		Assert.assertEquals(stack3.peek(3), 3333);
	}
}