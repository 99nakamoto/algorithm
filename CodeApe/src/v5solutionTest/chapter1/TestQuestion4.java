package v5solutionTest.chapter1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cc150.common.TestBase;
import v5solution.chapter1.Question4;

public class TestQuestion4 extends TestBase {

  private Question4 question;

  @Override
  protected void initInstance() {
    question = new Question4();
  }

  @Override
  @Test
  public void testPosCase() {
    String case1 = "Mr John Smith    ";
    assertEquals(case1.trim().replace(" ", "%20"),
        new String(question.replace(case1.toCharArray(), case1.trim().length())));
    String case2 = " Mr John Smith      ";
    assertEquals("%20" + case2.trim().replace(" ", "%20"),
        new String(question.replace(case2.toCharArray(), (" " + case2.trim()).length())));
  }

  @Override
  @Test
  public void testNegCase() {
  }

}
