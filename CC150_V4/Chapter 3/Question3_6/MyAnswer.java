package Question3_6;

import java.util.Stack;

public class MyAnswer {

	public static Stack<Integer> sort(Stack<Integer> s) {
		Stack<Integer> result = new Stack<Integer>();
		while (!s.isEmpty()) {
			Integer nextNum = s.pop();
			while (!result.isEmpty() && result.peek() < nextNum) {
				s.push(result.pop());
			}
			result.push(nextNum);
		}
		return result;
	}

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(3);
		s.push(2);
		s.push(24);
		s.push(34);
		s.push(19);
		s.push(3);
		s.push(4);
		s = sort(s);
		while (!s.isEmpty()) {
			System.out.println(s.pop());
		}
	}
}
