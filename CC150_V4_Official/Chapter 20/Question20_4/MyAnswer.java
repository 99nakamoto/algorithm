package Question20_4;

public class MyAnswer {

	public static int count2sCC150(int num) {

		int countOf2s = 0;
		int digit = 0;
		int seenDigits = 0;
		int pos = 0;
		int pow10_pos = 1;

		/*
		 * maintaining this value instead of calling pow() is an 6x perf gain
		 * (48s -> 8s) pow10_posMinus1. maintaining this value instead of
		 * calling Numof2s is an 2x perf gain (8s -> 4s). overall > 10x speedup
		 */
		while (num > 0) {
			digit = num % 10;
			int pow10_posMinus1 = pow10_pos / 10;
			countOf2s += digit * pos * pow10_posMinus1;
			/*
			 * we do this if digit <, >, or = 2
			 * 
			 * Digit < 2 implies there are no 2s contributed by this digit.
			 * 
			 * Digit == 2 implies there are 2 * numof2s contributed by the
			 * previous position + num of 2s contributed by the presence of this
			 * 2
			 */
			if (digit == 2) {
				countOf2s += seenDigits + 1;
			}
			/*
			 * Digit > 2 implies there are digit * num of 2s by the prev.
			 * position + 10^position
			 */
			else if (digit > 2) {
				countOf2s += pow10_pos;
			}
			seenDigits = seenDigits + pow10_pos * digit;
			pow10_pos *= 10;
			pos++;
			num = num / 10;
		}
		return (countOf2s);
	}

	public static int myAnswer(int n) {
		if (n == 0)
			return 0;
		int power = 1;
		while (power * 10 <= n) {
			power *= 10;
		}

		int first = n / power;
		int reminder = n % power;
		int firstDigit2count = 0;
		if (first > 2) {
			firstDigit2count = power;
		} else if (first == 2) {
			firstDigit2count = reminder + 1;
		}
		int totalCountBeforeReminder = firstDigit2count
				+ (first * myAnswer(power - 1));
		return totalCountBeforeReminder + myAnswer(reminder);
	}

	public static void main(String[] args) {
		for (int i = 1; i < 1400; i += 99) {
			int v1 = myAnswer(i);
			int v2 = count2sCC150(i);
			System.out.println("Between 0 and " + i
					+ ": \n                      " + v1 + " == " + v2);
		}
	}

}