package common;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Common {

	public static void printArray(int[] array) {
		if (array == null || array.length == 0) {
			System.out.println("The array you input is null/empty. ");
		}
		// System.out.print("Print array: ");
		System.out.print("{");
		StringBuilder sb = new StringBuilder();
		for (int i : array) {
			sb.append(", " + i);
		}
		System.out.println(sb.toString().substring(2) + "}");
	}

	public static void printList(List<?> list) {
		System.out.println("Print the list: ");
		for (Object obj : list) {
			System.out.println(obj.toString());
		}
	}

	public static boolean compareArray(int[] a, int[] b) {
		if (a.length != b.length) {
			return false;
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i]) {
				return false;
			}
		}
		return true;
	}

	public static boolean compareMatrix(int[][] a, int[][] b) {
		if (a.length != b.length) {
			return false;
		}
		for (int i = 0; i < a.length; i++) {
			if (!compareArray(a[i], b[i])) {
				return false;
			}
		}
		return true;
	}

	public static int factorial(int num) {
		if (num == 1) {
			return 1;
		} else if (num > 1) {
			return num * factorial(num - 1);
		} else {
			return -1; // Error
		}
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

	public static void printTreeInorder(TreeNode root) {
		if (root == null) {
			return;
		}
		printTreeInorder(root.left);
		System.out.print(Integer.toString(root.val) + " ");
		printTreeInorder(root.right);
	}

	public static void printLevelOrder(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
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