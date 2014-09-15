package Question4_9;

import java.util.ArrayList;
import java.util.List;

import CtCILibrary.TreeNode;

public class MyAnswer {

	public static void findSum(TreeNode node, int sum) {
		helper(new ArrayList<Integer>(), node, sum);
	}

	private static void helper(List<Integer> list, TreeNode node, int target) {
		if (node == null) {
			return;
		}
		list.add(node.data);
		int sum = 0;
		for (int i = list.size() - 1; i >= 0; i--) {
			sum += list.get(i);
			if (sum == target) {
				// print from i to the end
				printList(list, i);
			}
		}
		List<Integer> anotherList = new ArrayList<Integer>(list);
		helper(list, node.left, target);
		helper(anotherList, node.right, target);
	}

	private static void printList(List<Integer> list, int from) {
		for (int i = from; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
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
		findSum(root, 8);
	}
}
