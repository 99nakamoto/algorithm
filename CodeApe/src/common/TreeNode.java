package common;

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
		return buildBstHelper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static TreeNode buildBstHelper(int[] A, int min, int max) {
		int len = A.length;
		if (p >= len) {
			return null;
		} else if (A[p] < min || A[p] > max) {
			return null;
		}
		TreeNode root = new TreeNode(A[p]);
		p++;
		root.left = buildBstHelper(A, min, root.val);
		root.right = buildBstHelper(A, root.val, max);
		return root;
	}

	public static TreeNode constructTreeFromPreAndInorder(int[] preorder,
			int[] inorder) {
		if (preorder == null || inorder == null
				|| preorder.length != inorder.length) {
			return null;
		}
		return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0,
				inorder.length - 1);
	}

	private static TreeNode buildTreeHelper(int[] preorder, int a, int b,
			int[] inorder, int c, int d) {
		if (a > b) {
			return null;
		}
		int headVal = preorder[a];
		TreeNode head = new TreeNode(headVal);
		int p = c;
		while (p <= d) {
			if (inorder[p] == headVal) {
				break;
			}
			p++;
		}
		head.left = buildTreeHelper(preorder, a + 1, a + p - c, inorder, c,
				p - 1);
		head.right = buildTreeHelper(preorder, b - d + p + 1, b, inorder,
				p + 1, d);
		return head;
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

//	public boolean addNode(TreeNode node, int value) {
//		if (value == node.val)
//			return false;
//		if (value < node.val) {
//			if (node.left == null) {
//				node.left = new TreeNode(value);
//				return true;
//			} else {
//				return add(node.left, value);
//			}
//		} else if (value > node.val) {
//			if (node.right == null) {
//				node.right = new TreeNode(value);
//				return true;
//			} else {
//				return add(node.right, value);
//			}
//		}
//		return false;
//	}
}
