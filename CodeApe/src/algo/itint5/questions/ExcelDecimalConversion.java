package algo.itint5.questions;

public class ExcelDecimalConversion {

	static final int[] decimals = { 1, 2, 26, 27, 54, 3001, 100000 };
	static final String[] excels = { "A", "B", "Z", "AA", "BB", "DKK", "EQXD" };

	public static void main(String[] args) {
		ExcelDecimalConversion ins = new ExcelDecimalConversion();

		System.out.println("Test decToExcel()");
		for (int i = 0; i < decimals.length; i++) {
			System.out.println(ins.decToExcel(decimals[i]) + " should be "
					+ excels[i]);
		}

		System.out.println();
		System.out.println("Now, excelToDec()");
		for (int i = 0; i < decimals.length; i++) {
			System.out.println(ins.excelToDec(excels[i]) + " should be "
					+ decimals[i]);
		}
	}

	public String decToExcel(int decNum) {
		if (decNum == 0) {
			return "";
		}
		decNum--;
		char last = (char) ('A' + decNum % 26);
		return decToExcel(decNum / 26) + last;
	}

	public int excelToDec(String excelNum) {
		if (excelNum.equals("")) {
			return 0;
		}
		int len = excelNum.length();
		int last = 1 + excelNum.charAt(len - 1) - 'A';
		return excelToDec(excelNum.substring(0, len - 1)) * 26 + last;
	}

}
