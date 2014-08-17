package v5solutionTest.chapter17;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cc150.common.TestBase;
import v5solution.chapter17.Question13;
import v5solution.chapter17.Question13.BiNode;

/**
 * Consider a simple node-like data structure called BiNode, which has pointers
 * to two other nodes.
 * 
 * The data structure BiNode could be used to represent both a binary tree (were
 * first is the left node and second is the right node) or a doubly linked list
 * (where first is the previous node and second is the next node). Implement a
 * method to convert a binary search tree (implemented with BiNode) into a
 * doubly linked list in place.
 * 
 */
public class TestQuestion13 extends TestBase {

  private Question13 question = new Question13();

  @Override
  protected void initInstance() {
    question = new Question13();
  }

  @Override
  @Test
  public void testPosCase() {
    /*
     *          5 
     *         / \ 
     *       2    9 
     *      / \    \ 
     *     1   3    16
     *             /
     *            12
     */
    BiNode five = new BiNode(5);
    BiNode two = new BiNode(2);
    BiNode nine = new BiNode(9);
    BiNode one = new BiNode(1); 
    BiNode three = new BiNode(3);
    BiNode sixteen = new BiNode(16);
    BiNode twelve = new BiNode(12);
    five.first = two;
    five.second = nine;
    two.first = one;
    two.second = three;
    nine.second = sixteen;
    sixteen.first = twelve;

    BiNode newRoot = question.flatten(five);
    assertEquals(1, newRoot.val);
    assertEquals(2, newRoot.second.val);
    assertEquals(3, newRoot.second.second.val);
    assertEquals(5, newRoot.second.second.second.val);
    assertEquals(9, newRoot.second.second.second.second.val);
    assertEquals(12, newRoot.second.second.second.second.second.val);
    assertEquals(16, newRoot.second.second.second.second.second.second.val);
  }

  @Override
  @Test
  public void testNegCase() {
    // no negative case
  }

}
