package common;

import java.util.List;

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

	public static void printTreeInorder(TreeNode root) {
		if (root == null) {
			return;
		}
		printTreeInorder(root.left);
		System.out.print(Integer.toString(root.val) + " ");
		printTreeInorder(root.right);
	}
}