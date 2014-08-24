package v4cc150.chap1;

public class Q1_1_Modified {

	// This question is changed to input only small letter
	// from a to z
	
	// Difficulty level: 4
	// Time Spend: 

	public boolean solve(String str) {
		// this method used binary operations
		if (str == null) {
			return true;
		}
		int flag = 0;
		for (int i = 0; i < str.length(); i++) {
			int cur = str.charAt(i) - 'a';
			if (cur < 0 || cur > 31) {
				// invalid char input
				return false;
			}
			if ((flag >> cur & 1) == 1) {
				// char flag already marked
				return false;
			}
			flag = flag | 1 << cur;
		}
		return true;
	}

}