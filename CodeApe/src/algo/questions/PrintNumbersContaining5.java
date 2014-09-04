package algo.questions;
public class PrintNumbersContaining5 {

	// 写一个function，对于参数n，输出从0到n之间所有含5的数字。eg. func(30) 应该输出5，15，25

	public void solutionFromForum(int num) {
		if (num >= 5) {
			String str = String.valueOf(num);
			solve(str, "", str.length(), 0, false);
		}
	}

	private void solve(String number, String prefix, int length, int pos,
			boolean has5) {
		if (pos >= length) {
			System.out.print(Integer.parseInt(prefix) + ", ");
			return;
		}
		if (pos < length - 1 || has5) {
			// if not reached last digit, or if 5 already in the number
			// can append any number
			for (int i = 0; i <= 9; i++) {
				String tmp = prefix + i;
				if (Integer.parseInt(tmp) > Integer.parseInt(number.substring(
						0, pos + 1))) {
					continue;
				}

				if (i == 5) {
					solve(number, tmp, length, pos + 1, true);
				} else {
					solve(number, tmp, length, pos + 1, has5);
				}
			}
		} else {
			// else, we must append a 5
			String tmp = prefix + "5";
			if (Integer.parseInt(tmp) < Integer.parseInt(number.substring(0,
					pos + 1))) {
				solve(number, tmp, length, pos + 1, true);
			}
		}
	}

	public void mySolution(int num) {
		if (num >= 5) {
			String str = String.valueOf(num);
			helper(num, "", 0, str.length(), false);
		}
	}

	private void helper(int max, String prefix, int pos, int len, boolean have5) {
		if (pos == len) {
			int cur = Integer.parseInt(prefix);
			if (cur <= max) {
				System.out.print(cur + ", ");
			}
			return;
		}
		for (int i = 0; i < 10; i++) {
			if (pos == len - 1 && !have5 && i != 5) {
				continue;
			}
			helper(max, prefix + i, pos + 1, len, have5 || i == 5);
		}
	}

	public static void main(String[] argv) {
		PrintNumbersContaining5 s = new PrintNumbersContaining5();

		System.out.println("from forum http://goo.gl/e8s3py");
		s.solutionFromForum(130);
		System.out.println();
		System.out.println();
		System.out.println("revised by me: ");
		s.mySolution(130);
	}
}
