package Question10_4;

public class MyAnswer {

	public static int negate(int a) {
		if (a == Integer.MIN_VALUE) {
			System.out.println("A overflow happened");
			return 0;
		}
		// plus -1, then do XOR with 111111111
		// eg. 1 -> 0000000 -> 11111111 = -1
		// eg. -1 -> 11111110 -> 00000001 = 1
		return (a + -1) ^ -1;
	}

	public static int minus(int a, int b) {
		return a + negate(b);
	}

	public static boolean diffSign(int a, int b) {
		int xor = (a ^ b) & Integer.MIN_VALUE;
		return false;
	}

	public static int abs(int a) {
		return 0;
	}

	public static int multiply(int a, int b) {
		return 0;
	}

	public static int divide(int a, int b) throws java.lang.ArithmeticException {
		return 0;
	}

	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			int a = i - 10;
			int ans = negate(a);
			System.out.print(a + " negate = " + ans + ";  ");
		}
		System.out.println();

		for (int i = 0; i < 5; i++) {
			int a = randomInt(50);
			int b = randomInt(10);
			int ans = minus(a, b);
			if (ans != a - b) {
				System.out.println("ERROR");
			}
			System.out.print(a + " - " + b + " = " + ans + ";  ");
		}
		System.out.println();
		for (int i = 0; i < 5; i++) {
			int a = randomInt(50);
			int b = randomInt(10);
			int ans = multiply(a, b);
			if (ans != a * b) {
				System.out.println("ERROR");
			}
			System.out.print(a + " * " + b + " = " + ans + ";  ");
		}
		System.out.println();
		for (int i = 0; i < 5; i++) {
			int a = randomInt(10) + 1;
			int b = randomInt(10) + 1;
			System.out.print(a + " / " + b + " = ");
			int ans = divide(a, b);
			if (ans != a / b) {
				System.out.println("ERROR");
			}
			System.out.print(ans + ";  ");
		}
		System.out.println();
	}

}
