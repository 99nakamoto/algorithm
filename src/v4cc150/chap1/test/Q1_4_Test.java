package v4cc150.chap1.test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import v4cc150.chap1.Q1_4;

public class Q1_4_Test {

	private String str1;
	private String str2;
	private String str4;
	private String str5;
	private String str6;
	private String str7;
	private String str8;
	private String str9;
	private String str10;

	@Before
	public void setUp() {
		str1 = null;
		str2 = "";
		str4 = "ab";
		str5 = "AB";
		str6 = "ba";
		str7 = "   ";
		str8 = "   ";
		str9 = "CCCCb";
		str10 = "CCCbC";
	}

	@Test
	public void test() {
		Q1_4 q = new Q1_4();
		Assert.assertFalse(q.solve(str1, str1));
		Assert.assertTrue(q.solve(str2, str2));
		Assert.assertTrue(q.solve(str4, str6));
		Assert.assertTrue(q.solve(str7, str8));
		Assert.assertFalse(q.solve(str1, str2));
		Assert.assertFalse(q.solve(str2, str4));
		Assert.assertFalse(q.solve(str4, str5));
		Assert.assertTrue(q.solve(str9, str10));
	}
}