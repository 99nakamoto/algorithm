package algo.questions;

public class ProductAllOnes {

	public static void main(String[] args) {
		ProductAllOnes ins = new ProductAllOnes();

		System.out.println(ins.findMinAllOne(1));
		System.out.println(ins.findMinAllOne(3));
		System.out.println(ins.findMinAllOne(37));
		System.out.println(ins.findMinAllOne(7));
		System.out.println(ins.findMinAllOne(231));
		System.out.println(ins.findMinAllOne(793));

		System.out.println();

		System.out.println(ins.findMinAllOneMe(1));
		System.out.println(ins.findMinAllOneMe(3));
		System.out.println(ins.findMinAllOneMe(37));
		System.out.println(ins.findMinAllOneMe(7));
		System.out.println(ins.findMinAllOneMe(231));
		System.out.println(ins.findMinAllOneMe(793));
	}

	public int findMinAllOne(int a) {
		if (a < 0 || (a % 10) % 2 == 0 || a % 10 == 5)
			return -1;

		int ans = 1;
		for (int p = 1; p != 0; p %= a) {
			p = 10 * p + 1;
			++ans;
		}
		return a == 1 ? ans - 1 : ans;
	}

	public int findMinAllOneMe(int a) {
		if (a % 2 == 0) {
			return -1;
		}
		long target = 1;
		int digits = 1;
		while (target <= (Long.MAX_VALUE / 10) && target % a != 0) {
			target = target * 10 + 1;
			digits++;
		}
		if (target % a == 0) {
			return digits;
		} else {
			return -1;
		}
	}
}
