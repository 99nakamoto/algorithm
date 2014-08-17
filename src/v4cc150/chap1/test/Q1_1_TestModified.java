package v4cc150.chap1.test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import v4cc150.chap1.Q1_1_Modified;

public class Q1_1_TestModified {

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
		str3 = "f";
		str4 = "abcdefghijklmnopqrstuvwxyz";
		str5 = "quickbrownfx";
		str6 = "aweoqd";

		str7 = "ab cde";
		str8 = "ABCDEFD";
		str9 = "tijsldgdl@#$$%394 87 7g7 g9df7g9d7f98gdf9g 09g709g809 jlkfjgldfjglkfdg gjldg jlkdfhlkdfjhglfjgldsfjglkdf";
		str10 = " ";
	}

	@Test
	public void test() {
		Q1_1_Modified q = new Q1_1_Modified();
		Assert.assertTrue(q.solve(str1));
		Assert.assertTrue(q.solve(str2));
		Assert.assertTrue(q.solve(str3));
		Assert.assertTrue(q.solve(str4));
		Assert.assertTrue(q.solve(str5));
		Assert.assertTrue(q.solve(str6));

		Assert.assertFalse(q.solve(str7));
		Assert.assertFalse(q.solve(str8));
		Assert.assertFalse(q.solve(str9));
		Assert.assertFalse(q.solve(str10));
	}
}