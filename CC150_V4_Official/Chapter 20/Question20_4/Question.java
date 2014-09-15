package Question20_4;

public class Question {

	public static int count2sIterative(int num) {

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

	public static int count2sRecursive(int n) {
		// Example: n = 513

		// Base case
		if (n == 0) {
			return 0;
		}

		// Split apart 513 into 5 * 100 + 13.
		// [Power = 100; First = 5; Remainder = 13]
		int POWER = 1;
		while (10 * POWER < n) {
			POWER *= 10;
		}
		int firstDigit = n / POWER;
		int remainderNum = n % POWER;

		// Counts 2s from first digit
		int num2sFirstDigit = 0;
		if (firstDigit > 2) {
			num2sFirstDigit = POWER;
		} else if (firstDigit == 2) {
			// eg. number = 201, there would be (200, 201), 2 occurance
			num2sFirstDigit = remainderNum + 1;
		}

		// Count 2s from all other digits
		// THIS FORMULA IS IMPORTANT!!!!
		int num2sReminder = firstDigit * count2sRecursive(POWER - 1)
				+ count2sRecursive(remainderNum);

		return num2sFirstDigit + num2sReminder;
	}

	public static void main(String[] args) {
		for (int i = 1; i < 1400; i += 99) {
			int v1 = count2sRecursive(i);
			int v2 = count2sIterative(i);
			System.out.println("Between 0 and " + i
					+ ": \n                      " + v1 + " == " + v2);
		}
	}

}