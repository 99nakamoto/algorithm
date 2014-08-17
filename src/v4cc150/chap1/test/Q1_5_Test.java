package v4cc150.chap1.test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import v4cc150.chap1.Q1_5;

public class Q1_5_Test {

	private String str1;
	private String str2;
	private String str3;
	private String str4;
	private String str5;
	private String str6;
	private String str7;
	private String str8;
	private String str9;

	@Before
	public void setUp() {
		str1 = null;
		str2 = "";
		str3 = " ";
		str4 = "aaaahh";
		str5 = "%20";
		str6 = "     ";
		str7 = " Acc_4";
		str8 = "$%^ ";
		str9 = "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% 00000000000000000000000000000000";
	}

	@Test
	public void test() {
		Q1_5 q = new Q1_5();
		Assert.assertEquals(q.solve(str1), null);
		Assert.assertEquals(q.solve(str2), "");
		Assert.assertEquals(q.solve(str3), "%20");
		Assert.assertEquals(q.solve(str4), "aaaahh");
		Assert.assertEquals(q.solve(str5), "%20");
		Assert.assertEquals(q.solve(str6), "%20%20%20%20%20");
		Assert.assertEquals(q.solve(str7), "%20Acc_4");
		Assert.assertEquals(q.solve(str8), "$%^%20");
		Assert.assertEquals(q.solve(str9),
				"%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%2000000000000000000000000000000000");
	}
}