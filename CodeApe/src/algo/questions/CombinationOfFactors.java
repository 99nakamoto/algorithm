package algo.questions;
import java.util.ArrayList;
import java.util.List;

public class CombinationOfFactors {

	public static void main(String[] args) {
		CombinationOfFactors ins = new CombinationOfFactors();
		long startTime = System.currentTimeMillis();

		System.out.println("Start Run... ");

		List<List<Integer>> ans = ins.factorCombinations(24);
		for (List<Integer> list : ans) {
			for (int i : list)
				System.out.print(i + " ");
			System.out.println();
		}
		System.out.println();

		System.out.print("Total time = ");
		System.out.print((System.currentTimeMillis() - startTime) / 1000.0);
	}

	public List<List<Integer>> factorCombinations(int n) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		helper(ans, n, n / 2, new ArrayList<Integer>());
		return ans;
	}

	private void helper(List<List<Integer>> ans, int num, int largestFactor,
			List<Integer> path) {
		if (num == 1) {
			ans.add(new ArrayList<Integer>(path));
			return;
		}
		for (int i = largestFactor; i > 1; i--) {
			if (num % i == 0) {
				path.add(i);
				helper(ans, num / i, i, path);
				path.remove(path.size() - 1);
			}
		}
	}

}
