package algo.questions;

public class GreatestCommonDivisor {

	public static void main(String[] args) {
		GreatestCommonDivisor ins = new GreatestCommonDivisor();
		System.out.println(ins.test(1, 1));
		System.out.println(ins.test(0, 0));
		System.out.println(ins.test(0, 4));
		System.out.println(ins.test(2, 0));
		System.out.println(ins.test(2, 6));
		System.out.println(ins.test(3, 32));
		System.out.println(ins.test(3, 33));
		System.out.println(ins.test(15, 7));
		System.out.println(ins.test(16, 8));
		System.out.println(ins.test(1000000, 125));
	}

	private String test(int a, int b) {
		return a + " " + b + " => " + gcd(a, b);
	}

	public int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
}
