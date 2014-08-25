package v5solutionTest.chapter1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import common.TestBase;

import v5solution.chapter1.Question3;

/**
 * Given two strings, write a method to decide if one is a permutation of the
 * other.
 * 
 */
public class TestQuestion3 extends TestBase {

  private Question3 question;

  @Override
  protected void initInstance() {
    question = new Question3();
  }

  @Override
  @Test
  public void testPosCase() {
    assertTrue(question.isPermutation("", ""));
    assertTrue(question.isPermutation("abcde", "bdeac"));
    assertTrue(question.isPermutation("@!#$%^&*()", ")(*&^%$#!@"));
    assertTrue(question.isPermutation("aaa", "aaa"));
  }

  @Override
  @Test
  public void testNegCase() {
    assertFalse(question.isPermutation(null, ""));
    assertFalse(question.isPermutation("", null));
    assertFalse(question.isPermutation("aaa", "aaaa"));
    assertFalse(question.isPermutation("Aaa", "aaa"));
    assertFalse(question.isPermutation("ASDFQER@#$dsaf3dffa3",
        "ASFD#@fst4WEF@3 sdFA"));
  }

}
