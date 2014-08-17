package v4cc150.chap1.test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import v4cc150.chap1.Q1_8;

public class Q1_8_Test {

	private String str1;
	private String str2;
	private String str3;
	private String str4;
	private String str5;
	private String str6;
	private String str7;

	@Before
	public void setUp() {
		str1 = null;
		str2 = "";
		str3 = "a";
		str4 = "37";
		str5 = "AAAaa";
		str6 = "sasasasasasasa";
		str7 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
	}

	@Test
	public void test() {
		Q1_8 q = new Q1_8();
		Assert.assertTrue(q.solve(str1, null));
		Assert.assertTrue(q.solve(str2, ""));
		Assert.assertTrue(q.solve(str3, "a"));
		Assert.assertTrue(q.solve(str4, "37"));
		Assert.assertTrue(q.solve(str4, "73"));
		Assert.assertTrue(q.solve(str5, "AaaAA"));
		Assert.assertTrue(q.solve(str5, "aAAAa"));
		Assert.assertTrue(q.solve(str6, "asasasasasasas"));
		Assert.assertTrue(q.solve(str7,
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));

		Assert.assertFalse(q.solve(str2, " "));
		Assert.assertFalse(q.solve(str3, "b"));
		Assert.assertFalse(q.solve(str5, "AaAAa"));
		Assert.assertFalse(q.solve(str6, "sasasasasasas "));
	}
}