package algo.questions;

public class OverridePrivateMethod {
	private void foo() {
		int i = 1;
	}
}

class Child extends OverridePrivateMethod {
	// @Override
	private void foo() {
	}
}
