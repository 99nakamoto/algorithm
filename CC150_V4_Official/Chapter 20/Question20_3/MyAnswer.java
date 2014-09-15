package Question20_3;

public class MyAnswer {

	public static int[] pickMRandomly(int[] original, int m) {
		int[] ans = new int[m];
		for (int i = 0; i < m; i++) {
			int rand = Question.listRand.get(i);
			// note: rand is RN in the range [i, max]
			ans[i] = original[rand];
			original[rand] = original[i];
			// now (i)th position in original is dead
			// no one cares what value is at original[i]
		}
		return ans;
	}

}
