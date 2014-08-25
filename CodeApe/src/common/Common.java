package common;

import java.util.List;

public class Common {

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

	// public boolean add(TreeNode node, int value) {
	// if (value == node.val)
	// return false;
	// if (value < node.val) {
	// if (node.left == null) {
	// node.left = new TreeNode(value);
	// return true;
	// } else {
	// return add(node.left, value);
	// }
	// } else if (value > node.val) {
	// if (node.right == null) {
	// node.right = new TreeNode(value);
	// return true;
	// } else {
	// return add(node.right, value);
	// }
	// }
	// return false;
	// }
}