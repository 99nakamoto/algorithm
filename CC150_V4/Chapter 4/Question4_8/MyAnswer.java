package Question4_8;

import java.util.ArrayList;
import java.util.List;

import CareerCupLibrary.TreeNode;

public class MyAnswer {

	public static void find(TreeNode head, int target) {
		findSum(head, target, new ArrayList<Integer>());
	}

	private static void findSum(TreeNode node, int target, List<Integer> buffer) {
		if (node == null)
			return;

		buffer.add(node.data);
		int sum = 0;
		for (int i = buffer.size() - 1; i >= 0; i--) {
			sum += buffer.get(i);
			if (sum == target) {
				// from (i)th element until the last element is a valid path
				printPath(buffer, i);
			}
		}

		List<Integer> clone1 = new ArrayList<Integer>(buffer);
		findSum(node.left, target, clone1);

		List<Integer> clone2 = new ArrayList<Integer>(buffer);
		findSum(node.right, target, clone2);
	}

	private static void printPath(List<Integer> buffer, int start) {
		System.out.print("Path: ");
		for (int i = start; i < buffer.size(); i++) {
			System.out.print(buffer.get(i) + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(8);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(6);

		find(root, 8);

	}
}
