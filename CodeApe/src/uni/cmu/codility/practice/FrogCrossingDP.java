package uni.cmu.codility.practice;

public class FrogCrossingDP {

	// https://tkramesh.wordpress.com/2011/02/15/frog-crossing-more-on-dynamic-programming-3/

	public static void main(String[] args) {
		FrogCrossingDP ins = new FrogCrossingDP();

		int[] stones;
		// in the stones array, 1 represent a stone and 0 is a non-stone
		// note that 1st jump that the frog makes is of exactly 1 meter,
		// so the stone array must start with { 1, 1, ... }

		stones = new int[] { 1, 1, 0, 1, 0, 0, 1 };
		System.out.println("Can cross, result = " + ins.canCross(stones));

		stones = new int[] { 1, 1, 0, 1, 0, 0, 1, 0, 1 };
		System.out.println("Can cross, result = " + ins.canCross(stones));

		stones = new int[] { 1, 1, 0, 1, 0, 0, 1, 1 };
		System.out.println("Can not cross, result = " + ins.canCross(stones));

		stones = new int[] { 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1 };
		System.out.println("Can not cross, result = " + ins.canCross(stones));
	}

	public boolean canCross(int[] stones) {
		if (stones.length < 2 || (stones[0] != 1 || stones[1] != 1)) {
			// invalid input data
			return false;
		}
		int n = stones.length;
		boolean[][] dp = new boolean[n][n];
		// dp[i][j] denotes that frog can jump from index i to j

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (stones[i] == 0 || stones[j] == 0) {
					// if either stones i or stone j is removed, skip
					continue;
				}
				// note that j start from (i+1) because we make sure dp[i][i]
				// false. Otherwise, dp[i][i+1] will always be true

				if (i == 0) {
					// if jump from position 0, can only reach 1
					dp[i][j] = j == 1;
				} else {
					// if jump from other positions, need to check previous
					// distance, within range or not.
					int dis = j - i;
					for (int pre = i - dis - 1; pre <= i - dis + 1; pre++) {
						// pre is the previous position where frog jumps to i
						if (pre < 0) {
							continue;
						} else if (dp[pre][i]) {
							// frog jumps from pre to i, then frog is able to
							// jump from i to j
							dp[i][j] = true;
							break;
						}
					}
				}
				// finish calculating dp[i][j], now check termination
				if (j == n - 1 && dp[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
}
