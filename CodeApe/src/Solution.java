public class Solution {

	public void getNums(String number) {
		solve(number, "", number.length(), 0, false);
	}

	public void solve(String number, String prefix, int length, int pos,
			boolean has5) {
		if (pos >= length) {
			System.out.println(Integer.parseInt(prefix));
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

	public static void main(String[] argv) {
		Solution s = new Solution();
		s.getNums("120");
	}
}