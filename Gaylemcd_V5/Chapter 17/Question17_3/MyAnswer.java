package Question17_3;

public class MyAnswer {

	public static int countFactZeros(int num) {
		int count = 0;
		int divisor = 5;
		while (divisor < num) {
			count += num / divisor;
			divisor *= 5;
		}
		return count;
	}

	public static int factorial(int num) {
		if (num == 1) {
			return 1;
		} else if (num > 1) {
			return num * factorial(num - 1);
		} else {
			return -1; // Error
		}
	}

	public static void main(String[] args) {
		for (int i = 1; i < 12; i++) {
			System.out.println(i + "! (or " + factorial(i) + ") has "
					+ countFactZeros(i) + " zeros");
		}
	}
}
