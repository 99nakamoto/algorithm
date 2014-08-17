package itint5.questions;

public class ExpressionEvaluation {

	public static void main(String[] args) {
		ExpressionEvaluation ins = new ExpressionEvaluation();

		System.out.println("Test start");
		System.out.println(ins.evaluate("1+2+30") + " should be 33");
		System.out.println(ins.evaluate("1-2-30") + " should be -31");
		System.out.println(ins.evaluate("1*2*30") + " should be 60");
		System.out.println(ins.evaluate("30/2/3") + " should be 5");
		System.out.println(ins.evaluate("1+4-15+4") + " should be -6");
		System.out.println(ins.evaluate("1-3-6*3") + " should be -20");
		System.out.println(ins.evaluate("2*3-4*5") + " should be -14");
		System.out.println(ins.evaluate("1+7*8-7") + " should be 50");
		System.out.println(ins.evaluate("7+3*4*5+2+4-3-1") + " should be 69");
	}

	int p;

	public int evaluate(String expr) {
		p = 0;
		int firstNum = getNumber(expr);
		return helper(firstNum, expr);
	}

	private int helper(int preNum, String expr) {
		// now p points to a operator (or end of string)
		if (p == expr.length()) {
			return preNum;
		}
		char operator = expr.charAt(p);
		p++;
		int nextNum = getNumber(expr);
		switch (operator) {
		case '+':
			return preNum + helper(nextNum, expr);
		case '-':
			return preNum + helper(-1 * nextNum, expr);
		case '*':
			return helper(preNum * nextNum, expr);
		default:
			return helper(preNum / nextNum, expr);
		}
	}

	private int getNumber(String expr) {
		// now p points to a number
		int num = 0;
		while (p < expr.length() && expr.charAt(p) >= '0'
				&& expr.charAt(p) <= '9') {
			num = num * 10 + expr.charAt(p) - '0';
			p++;
		}
		return num;
	}

}
