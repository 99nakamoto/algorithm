package algo.questions.trees;

import common.Common;
import common.TreeNode;

public class ConstructBSTfromPreorder {

	int p;

	public static void main(String[] args) {
		ConstructBSTfromPreorder ins = new ConstructBSTfromPreorder();
		TreeNode root = ins.solution(new int[] { 4, 2, 1, 3, 6, 5, 7 });
		Common.printLevelOrder(root);
		System.out.println();
	}

	public TreeNode solution(int[] preorder) {
		p = 0;
		return helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private TreeNode helper(int[] A, int min, int max) {
		int len = A.length;
		if (p >= len || A[p] < min || A[p] > max) {
			return null;
		}
		TreeNode root = new TreeNode(A[p]);
		p++;
		root.left = helper(A, min, root.val);
		root.right = helper(A, root.val, max);
		return root;
	}
}
