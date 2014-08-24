package algo.questions;

public class PrintStringComparisonOrder {

	public static void main(String args[]) {
		for (int i = 1; i < 10; i++) {
			dfs("" + i);
		}
	}

	public static void dfs(String path) {
		if (Integer.parseInt(path) > 1000) {
			return;
		}
		System.out.println(path);
		for (int i = 0; i < 10; i++) {
			dfs(path + i);
		}
	}
}
