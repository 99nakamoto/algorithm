package Question3_2;

import CtCILibrary.AssortedMethods;

public class Question {

	public static void main(String[] args) {
		StackWithMin stack = new StackWithMin();
		StackWithMin2 stack2 = new StackWithMin2();
		StackMyAnswer stackMe = new StackMyAnswer();
		for (int i = 0; i < 15; i++) {
			int value = AssortedMethods.randomIntInRange(0, 100);
			stack.push(value);
			stack2.push(value);
			stackMe.push(value);
			System.out.print(value + ", ");
		}
		System.out.println('\n');
		for (int i = 0; i < 15; i++) {
			System.out.println("Popped ..... " + stack.pop().value + ", "
					+ stack2.pop() + ", " + stackMe.pop());
			System.out.println("New min ................ " + stack.min() + ", "
					+ stack2.min() + ", " + stackMe.min());
		}
	}

}
