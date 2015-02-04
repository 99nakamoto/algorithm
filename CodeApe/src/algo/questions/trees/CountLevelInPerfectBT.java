package algo.questions.trees;

import common.Common;
import common.TreeNode;

public class CountLevelInPerfectBT {

	// http://stackoverflow.com/questions/10721583/how-can-i-calculate-the-level-of-a-node-in-a-perfect-binary-tree-from-its-depth

	public int countLevel(TreeNode root, int k, int n) {
		int level = 0;
		while (k != 0) {
			k--;
			n = (n - 1) / 2;
			k = k % n;
			level++;
		}
		return level + 1;
	}

	public static void main(String[] args) {

		CountLevelInPerfectBT ins = new CountLevelInPerfectBT();

		// build a BST tree with 7 elements (3 layers)
		int[] bstInorder = new int[] { 0, 1, 2, 3, 4, 5, 6 };
		TreeNode root = Common.constructBstFromPreorder(bstInorder);

		System.out.println("Test data:");
		System.out.println("    0");
		System.out.println("   / \\");
		System.out.println("  1   4");
		System.out.println(" / \\ / \\");
		System.out.println("2  3 5  6");
		System.out.println();

		// start test
		for (int k = 0; k < 7; k++) {
			System.out.println(k + " @ Level " + ins.countLevel(root, k, 7));
		}
	}
}