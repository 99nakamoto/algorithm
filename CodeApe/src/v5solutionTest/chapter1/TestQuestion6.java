package v5solutionTest.chapter1;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import common.TestBase;

import v5solution.chapter1.Question6;

/**
 * Given an image represented by an NxN matrix, where each pixel in the image is
 * 4 bytes, write a method to rotate the image by 90 degrees (clockwise). Can
 * you do this in place?
 * 
 */
public class TestQuestion6 extends TestBase {

	private Question6 question;

	@Override
	protected void initInstance() {
		question = new Question6();
	}

	@Override
	@Test
	public void testPosCase() {
		int[][] case1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		int[][] expectedCase1 = { { 7, 4, 1 }, { 8, 5, 2 }, { 9, 6, 3 } };

		question.rotate(case1);
		// Commented out by Ran
		// because it's bad idea to prinln in unit test
		// http://stackoverflow.com/questions/10561540/in-junit-testing-is-it-possible-to-check-the-method-system-out-println

		// Utils.printMatrix(case1);
		// Utils.printMatrix(expectedCase1);
		assertArrayEquals(expectedCase1, case1);

		int[][] case2 = { { 10, 20, 30, 40 }, { 50, 60, 70, 80 },
				{ 90, 100, 110, 120 }, { 130, 140, 150, 160 }, };

		int[][] expectedCase2 = { { 130, 90, 50, 10 }, { 140, 100, 60, 20 },
				{ 150, 110, 70, 30 }, { 160, 120, 80, 40 } };
		question.rotate(case2);
		assertArrayEquals(expectedCase2, case2);
	}

	@Override
	@Test
	public void testNegCase() {
	}

}
