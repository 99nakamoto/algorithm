package algo.questions;

import java.util.LinkedList;
import java.util.Queue;

public class StackBuiltWithTwoQueue {

	// http://stackoverflow.com/questions/688276/implement-stack-using-two-queues

	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();

	public static void main(String[] args) {
		StackBuiltWithTwoQueue stack = new StackBuiltWithTwoQueue();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.pop());
		stack.push(4);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(8);
		stack.push(9);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

	public void push(int val) {
		q1.offer(val);
	}

	public int pop() {
		if (q1.isEmpty()) {
			System.out.print("Stack is empty now ");
			return -1;
		}
		while (q1.size() > 1) {
			q2.offer(q1.poll());
		}
		int topVal = q1.poll();
		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;
		return topVal;
	}
}
