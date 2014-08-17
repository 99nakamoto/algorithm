package v4cc150.chap9.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import v4cc150.chap9.Man;
import v4cc150.chap9.Q9_7;

public class Q9_7_Test {

	private List<Man> list;

	@Before
	public void setUp() {
		// (60, 100) (70, 150) (56, 90) (75, 190) (60, 95) (68,110)
		list = new ArrayList<Man>();
		list.add(new Man(60, 100));
		list.add(new Man(70, 150));
		list.add(new Man(56, 90));
		list.add(new Man(75, 190));
		list.add(new Man(60, 95));
		list.add(new Man(68, 110));
		list.add(new Man(20, 10));
		list.add(new Man(600, 3100));
	}

	@Test
	public void test() {
		Q9_7 q = new Q9_7();
		int num = q.longestTower(list);
		Assert.assertTrue(num == 6);
	}
}
