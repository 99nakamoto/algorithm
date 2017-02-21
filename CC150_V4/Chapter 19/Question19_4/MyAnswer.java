package Question19_4;

public class MyAnswer {

	public static int getMax(int a, int b) {
		int c = a - b;
		int signBit = c >> 31 & 1;
		// if (a-b) is negative, sign = 1
		// otherwise, sign = 0
		return a - signBit * c;
	}

	public static void main(String[] args) {
		int a = 103217;
		int b = 242239;
		System.out.println("max(" + a + ", " + b + ") = " + getMax(a, b));

		a = -234;
		b = -539;
		System.out.println("max(" + a + ", " + b + ") = " + getMax(a, b));
	}

}
