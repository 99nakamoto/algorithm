package algo.questions.trees;

import java.util.ArrayList;
import java.util.List;

import common.Common;
import common.TreeNode;

public class PrintBinaryTreeVerticalOrder {

	public static void main(String[] args) {
		PrintBinaryTreeVerticalOrder ins = new PrintBinaryTreeVerticalOrder();

		// test 1
		TreeNode tree1 = Common.constructBstFromPreorder(new int[] { 4, 2, 1,
				3, 6, 5, 7 });
		List<List<Integer>> ans1 = ins.printVertically(tree1);
		for (List<Integer> list : ans1) {
			Common.printList(list);
		}

		// test 2
		TreeNode tree2 = Common.constructBstFromPreorder(new int[] { 8, 4, 2,
				1, 3, 6, 5, 7, 12, 10, 9, 11, 14, 13, 15 });
		List<List<Integer>> ans2 = ins.printVertically(tree1);
		for (List<Integer> list : ans2) {
			Common.printList(list);
		}
	}

	public List<List<Integer>> printVertically(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();

		// 1. find the range of left bound and right bound
		int[] range = new int[2];
		findRange(root, range, 0);

		// 2. calculate number of columns in the result
		int rootIndex = 0 - range[0];
		int columns = range[1] - range[0] + 1;
		for (int i = 0; i < columns; i++) {
			ans.add(new ArrayList<Integer>());
		}

		// 3. fill in vertically in a recursive manner
		fillNode(ans, root, rootIndex);

		return ans;
	}

	private void fillNode(List<List<Integer>> ans, TreeNode node, int index) {
		if (node == null) {
			return;
		}
		ans.get(index).add(node.val);
		fillNode(ans, node.left, index - 1);
		fillNode(ans, node.right, index + 1);
	}

	private void findRange(TreeNode node, int[] range, int position) {
		if (node == null) {
			return;
		}
		if (position < range[0]) {
			range[0] = position;
		}
		if (position > range[1]) {
			range[1] = position;
		}
		findRange(node.left, range, position - 1);
		findRange(node.right, range, position + 1);
	}

}
