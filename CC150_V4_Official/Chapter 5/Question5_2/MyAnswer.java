package Question5_2;

public class MyAnswer {

	public static String printBinary(String n) {
		String[] num = n.split("\\.");
		int integer = Integer.parseInt(num[0]);
		double decimal = Double.parseDouble("0." + num[1]);

		// now convert decimal part, if can't convert, return ERROR
		StringBuilder sb = new StringBuilder();
		while (decimal != 0) {
			if (sb.length() > 32) {
				return "ERROR";
			}
			double newDoub = 2 * decimal;
			sb.append(newDoub >= 1 ? "1" : "0");
			decimal = newDoub % 1;
		}

		// now convert integer part
		String intStr = "";
		while (integer != 0) {
			intStr = ((integer & 1) == 1 ? "1" : "0") + intStr;
			integer = integer >> 1;
		}

		// return the 2 parts connected with a dot
		return intStr + "." + sb.toString();
	}

	public static void main(String[] args) {
		String n;

		n = "10.625";
		System.out.println(printBinary(n));

		n = "1.111";
		System.out.println(printBinary(n));
	}
}
