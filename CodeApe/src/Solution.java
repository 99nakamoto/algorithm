import common.Common;

public class Solution {

	public static void main(String[] args) {
		Solution ins = new Solution();
		int[] input = new int[] { 1, 0, 2, 0, 3, 0, 4 };
		Common.printArray(input);

		System.out.println(ins.divide(Integer.MIN_VALUE, -1));
	}

	int divide(int dividend, int divisor) {
		assert (divisor != 0);

		boolean flag = (dividend < 0) ^ (divisor < 0);
		long a = Math.abs((long) dividend);
		long b = Math.abs((long) divisor);
		long res = 0;
		int c = 1;
		while ((b << c) <= a) {
			++c;
		}
		--c;
		for (int i = c; i >= 0; --i) {
			if ((b << i) <= a) {
				res += ((long) 1 << i); // from high to low
				a -= (b << i); // reminder
			}
		}
		if (flag == true)
			res = -res;
		if (res > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		return (int) res;
	}
}
