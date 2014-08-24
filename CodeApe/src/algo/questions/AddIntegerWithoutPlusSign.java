package algo.questions;

public class AddIntegerWithoutPlusSign {

	public static void main(String[] args) {
		AddIntegerWithoutPlusSign ins = new AddIntegerWithoutPlusSign();

		System.out.println(ins.add(19, 22));
		System.out.println(ins.add2(19, 22));

		System.out.println(ins.add(103, 202));
		System.out.println(ins.add2(103, 202));

		System.out.println(ins.add(33, -4));
		System.out.println(ins.add2(33, -4));

		System.out.println(ins.add(33, -42));
		System.out.println(ins.add2(33, -42));
	}

	public int add(int x, int y) {
		// add y into x (and y results to 0)
		while (y != 0) {
			int carry = x & y;
			int sum = x ^ y;
			x = sum;
			y = carry << 1;
		}
		return x;
	}

	public int add2(int x, int y) {
		if (y == 0) {
			return x;
		}
		int carry = (x & y) << 1;
		return add2(x ^ y, carry);
	}
}
