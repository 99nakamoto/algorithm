package Question9_11;

public class MyAnswer {

	public static int countMyAnswer(String exp, boolean result) {
		if (exp.length() == 1) {
			return convertIntToBool(exp.charAt(0)) == result ? 1 : 0;
		}
		// eg. 1^0|0|1
		// result: true
		int totalCount = 0;
		for (int i = 1; i < exp.length(); i += 2) {

			char op = exp.charAt(i);
			String firstHalf = exp.substring(0, i);
			String secondHalf = exp.substring(i + 1);

			int firstHalfTrue = countMyAnswer(firstHalf, true);
			int firstHalfFalse = countMyAnswer(firstHalf, false);
			int secondHalfTrue = countMyAnswer(secondHalf, true);
			int secondHalfFalse = countMyAnswer(secondHalf, false);

			if (evaluate('0', op, '0') == result) {
				totalCount += firstHalfFalse * secondHalfFalse;
			}
			if (evaluate('0', op, '1') == result) {
				totalCount += firstHalfFalse * secondHalfTrue;
			}
			if (evaluate('1', op, '0') == result) {
				totalCount += firstHalfTrue * secondHalfFalse;
			}
			if (evaluate('1', op, '1') == result) {
				totalCount += firstHalfTrue * secondHalfTrue;
			}
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
