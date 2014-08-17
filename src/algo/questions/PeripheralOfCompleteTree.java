package algo.questions;

import cc150.common.TreeNode;

public class PeripheralOfCompleteTree {

	public static void main(String[] args) {
		PeripheralOfCompleteTree ins = new PeripheralOfCompleteTree();

		TreeNode completeTree = TreeNode.constructBstFromPreorder(new int[] {
				4, 2, 1, 3, 6, 5, 7 });
		ins.peripheral(completeTree);

		TreeNode completeTree2 = TreeNode.constructBstFromPreorder(new int[] {
				8, 4, 2, 1, 3, 6, 5, 7, 12, 10, 9, 11, 14, 13, 15 });
		ins.peripheral(completeTree2);
	}

	public enum PeriType {
		LEFT, RIGHT, LEAF
	}

	private void peripheral(TreeNode root) {
		printNode(root);
		helper(root.left, PeriType.LEFT);
		helper(root.right, PeriType.RIGHT);
		System.out.println();
	}

	private void helper(TreeNode node, PeriType type) {
		if (node == null) {
			return;
		}
		switch (type) {
		case LEFT:
			printNode(node);
			helper(node.left, PeriType.LEFT);
			helper(node.right, PeriType.LEAF);
			break;
		case RIGHT:
			helper(node.left, PeriType.LEAF);
			helper(node.right, PeriType.RIGHT);
			printNode(node);
			break;
		case LEAF:
			if (node.left == null && node.right == null) {
				printNode(node);
			} else {
				helper(node.left, PeriType.LEAF);
				helper(node.right, PeriType.LEAF);
			}
			break;
		}
	}

	private void printNode(TreeNode root) {
		System.out.print(root.val + " ");
	}
}
