package cc150.common;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}

	private static int p;

	public static TreeNode constructBstFromPreorder(int[] preorder) {
		p = 0;
		return helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static TreeNode helper(int[] A, int min, int max) {
		int len = A.length;
		if (p >= len) {
			return null;
		} else if (A[p] < min || A[p] > max) {
			return null;
		}
		TreeNode root = new TreeNode(A[p]);
		p++;
		root.left = helper(A, min, root.val);
		root.right = helper(A, root.val, max);
		return root;
	}

	public void printLevelOrder() {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(this);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				System.out.print(node.val + " ");
				if (node.left != null) {
					q.offer(node.left);
				}
				if (node.right != null) {
					q.offer(node.right);
				}
			}
			System.out.println();
		}
	}
}