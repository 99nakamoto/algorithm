package v4cc150.chap1.test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import v4cc150.chap1.Q1_2;

public class Q1_2_Test {

	private String str1;
	private String str2;
	private String str3;
	private String str4;
	private String str5;
	private String str6;
	private String str7;
	private String str8;
	private String str9;

	private String str11;
	private String str12;
	private String str13;
	private String str14;
	private String str15;
	private String str16;
	private String str17;
	private String str18;
	private String str19;

	@Before
	public void setUp() {
		str1 = null;
		str2 = "";
		str3 = " ";
		str4 = "#";
		str5 = " 908de";
		str6 = "44 s7";
		str7 = "aaaaa";
		str8 = "abababababababab";
		str9 = "5 6 5 6 5 6 5 6 5 6 5 6 5 6 5 6 5 6 5 6 a b a b";

		str11 = null;
		str12 = "";
		str13 = " ";
		str14 = "#";
		str15 = "d809 e";
		str16 = "s 447";
		str17 = "aaaaa";
		str18 = "abababababababab";
		str19 = " a b a 6 5 6 5 6 5 6 5 6 5 6 5 6 5 6 5 6 5 6 5b";
	}

	@Test
	public void test() {
		Q1_2 q = new Q1_2();
		Assert.assertEquals(q.solve(str1), str11);
		Assert.assertEquals(q.solve(str2), str12);
		Assert.assertEquals(q.solve(str3), str13);
		Assert.assertEquals(q.solve(str4), str14);
		Assert.assertEquals(q.solve(str5), str15);
		Assert.assertEquals(q.solve(str6), str16);
		Assert.assertEquals(q.solve(str7), str17);
		Assert.assertEquals(q.solve(str8), str18);
		Assert.assertEquals(q.solve(str9), str19);
	}
}