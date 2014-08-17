package algo.questions;

public class DecToHexConversion {

	public static void main(String[] args) {
		DecToHexConversion ins = new DecToHexConversion();
		int dec = 305445566;
		String hex = ins.decToHex(dec);
		System.out.println(hex);
	}

	private final char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7',
			'8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
	private final int flag = 0x0F;

	public String decToHex(int dec) {
		char[] hex = new char[8];
		for (int i = 7; i >= 0; i--) {
			int oneDigit = flag & dec;
			dec >>= 4;
			hex[i] = hexDigits[oneDigit];
		}
		return String.valueOf(hex);
	}
}
