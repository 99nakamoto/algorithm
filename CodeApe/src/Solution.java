public class Solution {

	public static void main(String[] args) {
		Solution ins = new Solution();
		long startTime = System.currentTimeMillis();

		System.out.println("Start Run... ");
		String infix, postfix;

		infix = "";
		postfix = ins.infixToPostfix(infix);
		System.out.println(infix);
		System.out.println(postfix);

		System.out.print("Total time = ");
		System.out.print((System.currentTimeMillis() - startTime) / 1000.0);
	}

	public String infixToPostfix(String infix) {
		return infix + "d";
	}
}
