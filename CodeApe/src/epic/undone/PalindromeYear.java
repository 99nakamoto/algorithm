package epic.undone;

class PalindromeYear {

	public void printPalindrome(int year1, int year2) {

		int[] month = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		String mm = "";
		String dd = "";
		String yy = "";
		int m = 0;
		int d = 0;
		for (int currentYear = year1; currentYear <= year2; currentYear++) {

			if ((currentYear % 400 == 0)
					|| ((currentYear % 100 != 0) && (currentYear % 4 == 0)))
				month[1] = 29;
			yy = Integer.toString(currentYear);
			mm = Integer.toString(currentYear % 10)
					+ Integer.toString((currentYear / 10) % 10);
			dd = Integer.toString((currentYear / 100) % 10)
					+ Integer.toString((currentYear / 1000) % 10);
			m = Integer.parseInt(mm);
			d = Integer.parseInt(dd);

			if (m > 0 && m <= 12 && d > 0 && d <= month[m - 1])
				System.out.println(mm + "/" + dd + "/" + yy);

		}

	}

	public static void main(String[] args) {

		PalindromeYear py = new PalindromeYear();
		py.printPalindrome(2000, 2060);

	}

}