package design_questions.OOP.packB;

import design_questions.OOP.packA.DemoProtechedClassA;

public class DemoProtechedClassB extends DemoProtechedClassA {

	public DemoProtechedClassB() {
		val = 5;
	}

	public String getColor() {
		return super.getColor();
	}
}
