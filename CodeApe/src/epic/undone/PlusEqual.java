package epic.undone;

public class PlusEqual {

	public static void main(String[] args) {
		PlusEqual ins = new PlusEqual();

		System.out.println(ins.plusEqual("2311491"));
		System.out.println(ins.plusEqual("17512"));

		System.out.println();
	}

	private void solution() {
		// another code at
		// http://www.careercup.com/question?id=13115667
	}

	public boolean isOK(int num1, int num2, int num3) {
		if (num1 + num2 == num3)
			return true;
		if (num1 + num3 == num2)
			return true;
		if (num2 + num3 == num1)
			return true;
		return false;
	}

	public boolean plusEqual(String num) {
		int len = num.length();
		int n = len / 2;
		// doing this because each number can be at most length n;
		// e.g. if length = 6, n = 3, using other 3 digits to form another two
		// numbers summing to this number;
		// if length = 7, n = 3; using other 4 digits to form another two
		// numbers.
		// Notice n = 4 is impossible to work. Because with other 3 digits, we
		// can not form two numbers summing to a 4 digits num.

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n + i + 1; j++) {
				String n1 = num.substring(0, i + 1);// length: [1,n];
				String n2 = num.substring(i + 1, j + 1);// length: [1,n];
				String n3 = num.substring(j + 1, len);// length:[1, n-2];

				if (isOK(Integer.parseInt(n1), Integer.parseInt(n2),
						Integer.parseInt(n3))) {
					System.out.println(n1 + " " + n2 + " " + n3);
					return true;
				}
			}
		}
		return false;
	}

}
