package algo.questions;

public class InfixToPostfix {

	public static void main(String[] args) {
		InfixToPostfix ins = new InfixToPostfix();
		long startTime = System.currentTimeMillis();

		System.out.println("Start Run... ");
		String input;

		input = "a*b+2";
		System.out.println(ins.solve(input));

		System.out.print("Total time = ");
		System.out.print((System.currentTimeMillis() - startTime) / 1000.0);
	}

	public String solve(String infix) {
		StringBuilder sb = new StringBuilder();
		// get next operand or non-operand
		// notice that operand is >=1 chars
		int p = 0;
		int len = infix.length();
		while (p != len) {
			if (isDigit(infix.charAt(p))) {
				// if char at p is a digit
				int q = p;
				while (q != len && isDigit(infix.charAt(q))) {
					q++;
				}
				// it is a number in the range [p, q-1]
				sb.append(infix.substring(p, q));
				p = q;
			} else {
				// if char at p is + - * / or ( )
				
			}
		}
		return sb.toString();
	}

	private boolean isDigit(char ch) {
		return '0' <= ch && ch <= '9';
	}
}
