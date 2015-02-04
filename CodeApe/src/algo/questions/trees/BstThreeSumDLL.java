package algo.questions.trees;

import common.Common;
import common.TreeNode;

public class BstThreeSumDLL {

	public static void main(String[] args) {
		BstThreeSumDLL ins = new BstThreeSumDLL();

		// test 1
		System.out.println("Test start");
		TreeNode tree1 = Common.constructBstFromPreorder(new int[] { 4, 2, 1,
				3, 6, 5, 7 });
		ins.findTriplet(tree1, 14);
		System.out.println();

		// test 2
		System.out.println("2nd test");
		TreeNode tree2 = Common.constructBstFromPreorder(new int[] { 8, 4, 2,
				1, 3, 6, 5, 7, 12, 10, 9, 11, 14, 13, 15 });
		ins.findTriplet(tree2, 7);
	}

	public void findTriplet(TreeNode root, int target) {
		TreeNode[] dll = convertToDll(root);
		TreeNode head = dll[0];
		TreeNode tail = dll[1];
		// note that the bst inorder dll should already in sorted by value
		TreeNode first = head;
		while (first.right != null) {
			TreeNode left = first.right;
			TreeNode right = tail;
			while (left.val < right.val) {
				int diff = first.val + left.val + right.val - target;
				if (diff == 0) {
					System.out.println("Found triplet: " + first.val + " "
							+ left.val + " " + right.val + " for sum of "
							+ target);
				}
				if (diff <= 0) {
					left = left.right;
				}
				if (diff >= 0) {
					right = right.left;
				}
			}
			first = first.right;
		}
	}

	private TreeNode[] convertToDll(TreeNode node) {
		TreeNode[] ans = new TreeNode[2];
		// do the left side of node
		if (node.left == null) {
			ans[0] = node;
		} else {
			TreeNode[] preAns = convertToDll(node.left);
			ans[0] = preAns[0];
			node.left = preAns[1];
			preAns[1].right = node;
		}
		// do the right side of node
		if (node.right == null) {
			ans[1] = node;
		} else {
			TreeNode[] postAns = convertToDll(node.right);
			ans[1] = postAns[1];
			node.right = postAns[0];
			postAns[0].left = node;
		}
		return ans;
	}
}
