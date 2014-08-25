package algo.oop;

class Base {
	void doSomething() {
		System.out.println("Base");
	}
}

class Derived extends Base {
	void doSomething() {
		System.out.println("Derived");
	}
}

public class JavaUpcasting {
	public static void main(String[] args) {
		Base instance = new Derived();
		instance.doSomething();
	}
}
