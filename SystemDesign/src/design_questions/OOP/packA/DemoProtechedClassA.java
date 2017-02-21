package design_questions.OOP.packA;

import design_questions.OOP.packB.DemoProtechedClassB;

public class DemoProtechedClassA {

	protected int val = 10;

	protected String getColor() {
		return "colored";
	}

	public static void main(String[] args) {
		DemoProtechedClassA ins = new DemoProtechedClassA();
		System.out.println("val is " + ins.val);
		System.out.println("color is " + ins.getColor());
		System.out.println();

		DemoProtechedClassB ins2 = new DemoProtechedClassB();
		System.out.println("val is " + ins2.val);
		System.out.println("color is " + ins2.getColor());
	}
}
