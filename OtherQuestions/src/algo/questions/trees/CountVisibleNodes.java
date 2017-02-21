package algo.questions.trees;

import common.TreeNode;

public class CountVisibleNodes {

	public int countVisible(TreeNode root) {
		return helper(root, Integer.MIN_VALUE);
	}

	private int helper(TreeNode node, int ancesterMax) {
		if (node == null) {
			return 0;
		}
		int newMax = Math.max(ancesterMax, node.val);
		if (node.val > ancesterMax) {
			return 1 + helper(node.left, newMax) + helper(node.right, newMax);
		} else {
			return helper(node.left, newMax) + helper(node.right, newMax);
		}
	}

	public static void main(String[] args) {
		CountVisibleNodes ins = new CountVisibleNodes();

		TreeNode root = TreeNode.constructTreeFromPreAndInorder(new int[] { 5, 3,
				20, 21, 10, 1 }, new int[] { 20, 3, 21, 5, 1, 10 });

		System.out.println(ins.countVisible(root));
	}
}
