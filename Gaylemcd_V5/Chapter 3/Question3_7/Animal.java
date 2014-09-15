package Question3_7;

public abstract class Animal {
	int order;
	String name;

	public Animal(String n) {
		name = n;
	}

	public abstract String name();

	public boolean isOlderThan(Animal a) {
		return this.order < a.order;
	}
}

class Cat extends Animal {
	public Cat(String n) {
		super(n);
	}

	public String name() {
		return "Cat: " + name;
	}
}

class Dog extends Animal {
	public Dog(String n) {
		super(n);
	}

	public String name() {
		return "Dog: " + name;
	}
}
