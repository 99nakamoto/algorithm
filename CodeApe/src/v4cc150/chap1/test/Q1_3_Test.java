package v4cc150.chap1.test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import v4cc150.chap1.Q1_3;

public class Q1_3_Test {

	private String str1;
	private String str2;
	private String str3;
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
		str3 = "a";
		str4 = " ";
		str5 = "     ";
		str6 = "    f  ";
		str7 = "abbbbbbb bbbbbbbbbbbbba";
		str8 = "123123dxddddddddddddddddddddddd123121321";
		str9 = "fhfhfhfhfhfhfhfhfhfhfhfhfhfhfhfhfhfhfhfhfhfhfhfhfhfhfhfhfhfhfhfhfh";
		str10 = "$%^&^%$%^&^%^$%%^^^%))";
	}

	@Test
	public void test() {
		Q1_3 q = new Q1_3();
		Assert.assertEquals(q.solve(str1), null);
		Assert.assertEquals(q.solve(str2), "");
		Assert.assertEquals(q.solve(str3), "a");
		Assert.assertEquals(q.solve(str4), " ");
		Assert.assertEquals(q.solve(str5), " ");
		Assert.assertEquals(q.solve(str6), " f");
		Assert.assertEquals(q.solve(str7), "ab ");
		Assert.assertEquals(q.solve(str8), "123dx");
		Assert.assertEquals(q.solve(str9), "fh");
		Assert.assertEquals(q.solve(str10), "$%^&)");
	}
}