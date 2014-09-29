package Question17_4;

public class MyAnswer {

	public static int getMax(int a, int b) {
		int sign;
		// if a,b have different sign, then go with first number
		if (sign(a) == sign(b)) {
			sign = sign(a - b);
		} else {
			sign = sign(a);
		}
		// sign is 0 if a >= b
		// sign is -1 is a < b
		return a + (a - b) * sign;
	}

	private static int sign(int c) {
		return c >> 31;
	}

	public static void main(String[] args) {

		int a = -15;
		int b = 26;
		System.out.println("max(" + a + ", " + b + ") = " + getMax(a, b));

		a = -15;
		b = 214748;
		System.out.println("max(" + a + ", " + b + ") = " + getMax(a, b));

		a = 15;
		b = -214748;
		System.out.println("max(" + a + ", " + b + ") = " + getMax(a, b));

		a = 214748;
		b = -15;
		System.out.println("max(" + a + ", " + b + ") = " + getMax(a, b));

		a = 214748;
		b = -214748;
		System.out.println("max(" + a + ", " + b + ") = " + getMax(a, b));

		a = -15;
		b = 2147483647;
		System.out.println("max(" + a + ", " + b + ") = " + getMax(a, b));

		a = 2147483647;
		b = -15;
		System.out.println("max(" + a + ", " + b + ") = " + getMax(a, b));

	}

}
