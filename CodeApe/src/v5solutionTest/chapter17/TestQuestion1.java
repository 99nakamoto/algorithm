package v5solutionTest.chapter17;

import static org.junit.Assert.assertArrayEquals;

import java.util.Random;

import org.junit.Test;

import cc150.common.TestBase;
import v5solution.chapter17.Question1;

/**
 * Write a function to swap two numbers in place (that is, without temporary
 * variables).
 * 
 */
public class TestQuestion1 extends TestBase {
  
  private Question1 question;

  @Override
  protected void initInstance() {
    question = new Question1();
  }

  @Override
  @Test
  public void testPosCase() {
    Random rnd = new Random();
    for (int c = 0; c < 1000000; ++c) {
      int first = rnd.nextInt();
      int second = rnd.nextInt();
      assertArrayEquals(new int[] {second, first}, question.swap(first, second));
    }
  }

  @Override
  @Test
  public void testNegCase() {
    //  no negative case
  }

}
