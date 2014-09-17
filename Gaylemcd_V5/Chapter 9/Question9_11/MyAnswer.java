package Question9_11;

public class MyAnswer {

	public static int countMyAnswer(String exp, boolean result) {
		// eg. 1^0|0|1
		// result: true
		int totalCount = 0;
		if (exp.length() == 1) {
			if (convertIntToBool(exp.charAt(0)) == result) {
				return 1;
			} else {
				return 0;
			}
		} else {
			char num1 = exp.charAt(0);
			char op = exp.charAt(1);
			char num2 = exp.charAt(2);
			// the answer comprised of 2 parts:
			// 1. num1 evaluate with exp.substring(2)
			// 2. num1 evaluate with num2, then modify the exp

			// part 1
			if (exp.length() > 3) {
				if (evaluate(num1, op, '0') == result) {
					totalCount += countMyAnswer(exp.substring(2), false);
				}
				if (evaluate(num1, op, '1') == result) {
					totalCount += countMyAnswer(exp.substring(2), true);
				}
			}
			// part 2, calculate only if exp.length() is larger than 3
			int firstResult = convertBoolToInt(evaluate(num1, op, num2));
			String newExp = firstResult + exp.substring(3);
			totalCount += countMyAnswer(newExp, result);
		}
		return totalCount;
	}

	private static boolean convertIntToBool(char num) {
		if (num == '1') {
			return true;
		} else {
			return false;
		}
	}

	private static int convertBoolToInt(boolean b) {
		if (b == true) {
			return 1;
		} else {
			return 0;
		}
	}

	private static boolean evaluate(char num1, char op, char num2) {
		boolean b1 = convertIntToBool(num1);
		boolean b2 = convertIntToBool(num2);
		if (op == '&') {
			return b1 & b2;
		} else if (op == '|') {
			return b1 | b2;
		} else if (op == '^') {
			return b1 ^ b2;
		}
		System.out.println("Did not found operator " + op);
		return false;
	}
}
