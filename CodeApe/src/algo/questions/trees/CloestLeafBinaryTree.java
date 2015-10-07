package algo.questions.trees;

import java.util.ArrayList;
import java.util.List;

import common.Common;
import common.TreeNode;

public class CloestLeafBinaryTree {

	public static void main(String[] args) {
		CloestLeafBinaryTree ins = new CloestLeafBinaryTree();
		long startTime = System.currentTimeMillis();

		System.out.println("Start Run... ");

		int[] preorder = new int[] { 1, 2, 3, 5, 7, 9, 10, 6, 8, 11 };
		int[] inorder = new int[] { 2, 1, 9, 7, 10, 5, 3, 6, 11, 8 };
		TreeNode root = TreeNode.constructTreeFromPreAndInorder(preorder, inorder);

		System.out.println("Input tree is: ");
		Common.printLevelOrder(root);

		System.out.println();
		System.out.println("Testing: ");
		for (int i = 1; i <= 11; i++) {
			if (i == 4)
				continue;
			System.out.println("Closest key to " + i + " is " + ins.findClosest(root, i));
		}

		System.out.print("Total time = ");
		System.out.print((System.currentTimeMillis() - startTime) / 1000.0);
	}

	int answer;

	public int findClosest(TreeNode root, int key) {
		answer = Integer.MAX_VALUE;
		helper(root, key, new ArrayList<TreeNode>());
		return answer;
	}

	private void helper(TreeNode node, int key, List<TreeNode> path) {
		if (node == null) {
			return;
		} else if (node.val != key) {
			path.add(node);
			helper(node.left, key, path);
			helper(node.right, key, path);
			path.remove(path.size() - 1);
		} else {
			// key matches with current node value
			answer = lenToLowerLeaf(node);
			// answer initially = cloest leaf from lower

			int len = path.size();
			for (int i = 0; i < len; i++) {
				// for every ancestor, calculate distance and compare
				int ithToLowerLeaf = lenToLowerLeaf(path.get(i));
				answer = Math.min(answer, (len - i) + ithToLowerLeaf);
			}
		}
	}

	private int lenToLowerLeaf(TreeNode node) {
		if (node == null) {
			return Integer.MAX_VALUE;
		} else if (node.left == null && node.right == null) {
			return 0;
		} else {
			return 1 + Math.min(lenToLowerLeaf(node.left), lenToLowerLeaf(node.right));
		}
	}
}
