package design_questions.OOP;

public class PolymorphismSubstitutabilityDemo {

	public static void main(String[] args) {
		Circle c1 = new Cylinder(1, "white", 10);
		System.out.println(c1.getClass());
		System.out.println(c1.getRadius());
		System.out.println(c1.getColor());
		System.out.println(c1.getArea());
	}
}

class Circle {
	int radius;
	String color;

	public Circle(int a, String b) {
		this.radius = a;
		this.color = b;
	}

	public int getRadius() {
		return radius;
	}

	public String getColor() {
		return color;
	}

	public double getArea() {
		return 3.14159 * Math.pow(radius, 2);
	}
}

class Cylinder extends Circle {
	int height;

	public Cylinder(int a, String b, int c) {
		super(a, b);
		this.height = c;
	}

	public int getHeight() {
		return height;
	}

	public double getArea() {
		return super.getArea() * height;
	}
}
