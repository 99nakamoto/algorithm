package v4cc150.chap3.test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import v4cc150.chap3.Q3_3;

public class Q3_3_Test {

	private Q3_3 stack;

	@Before
	public void setUp() {
		stack = new Q3_3(3);
	}

	@Test
	public void test() {
		for (int i = 1; i <= 8; i++) {
			stack.push(i);
		}
		// Stack  One : 1, 2, 3
		// Stack  Two : 4, 5, 6
		// Stack Three: 7, 8
		Assert.assertEquals((int) stack.popAt(1), 3);
		Assert.assertEquals((int) stack.popAt(2), 6);
		Assert.assertEquals((int) stack.popAt(3), 8);
		Assert.assertEquals((int) stack.popAt(2), 5);
		Assert.assertEquals((int) stack.popAt(2), 4);
		Assert.assertEquals((int) stack.pop(), 7);
		Assert.assertEquals((int) stack.pop(), 2);
		Assert.assertEquals((int) stack.pop(), 1);
		Assert.assertEquals(stack.pop(), null);
	}
}