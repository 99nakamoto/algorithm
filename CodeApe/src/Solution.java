public class Solution {

	public static void main(String[] args) {
		Solution ins = new Solution();
		int ans = ins.divide(-2147483648, -1);
		System.out.println(ans);
	}

	public int divide(int dividend, int divisor) {
		int sign = 1;
		long x = dividend;
		long y = divisor;
		if (x < 0) {
			x = 0 - x;
			sign *= -1;
		}
		if (y < 0) {
			y = 0 - y;
			sign *= -1;
		}
		return divide(sign, x, y);
	}

	private int divide(int sign, long x, long y) {
		// both x and y are positive numbers
		if (x < y) {
			return 0;
		}
		long quotient = 0;
		long partialQuotient;
		long partialSubtract;
		while (x >= y) {
			// the idea is to subtract a certain times of x from y
			// and save the remainder value back to x
			partialQuotient = 1;
			partialSubtract = y;
			while ((partialSubtract << 1) <= x) {
				partialQuotient <<= 1; // doubles quotient
				partialSubtract <<= 1; // doubles subtraction
			}
			x -= partialSubtract;
			quotient += partialQuotient;
		}
		long finalQuo = sign * quotient;
		if (finalQuo < Integer.MIN_VALUE || finalQuo > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		} else {
			return (int) finalQuo;
		}
	}
}
