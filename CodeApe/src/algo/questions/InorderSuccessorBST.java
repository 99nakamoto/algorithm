package algo.questions;

import common.TreeNode;

public class InorderSuccessorBST {

	public static void main(String[] args) {
		InorderSuccessorBST ins = new InorderSuccessorBST();

		TreeNode tree = TreeNode.constructBstFromPreorder(new int[] { 4, 2, 1,
				3, 6, 5, 7 });

		System.out.println(ins.inorderSuccessor(tree, tree).val + " should be 5");
		System.out.println(ins.inorderSuccessor(tree, tree.left).val + " should be 3");
		System.out.println(ins.inorderSuccessor(tree, tree.left.right).val
				+ " should be 4");
		System.out.println(ins.inorderSuccessor(tree, tree.right).val + " should be 7");
		System.out.println(ins.inorderSuccessor(tree, tree.right.right).val
				+ " should be -1");
	}

	public TreeNode inorderSuccessor(TreeNode root, TreeNode target) {
		if (target.right != null) {
			return this.findLeftMost(target.right);
		} else {
			return this.traverse(root, new TreeNode(-1), target);
		}
	}

	private TreeNode traverse(TreeNode cur, TreeNode pre, TreeNode target) {
		if (cur.val == target.val) {
			return pre;
		} else if (cur.val < target.val) {
			cur = cur.right;
			return traverse(cur, pre, target);
		} else {
			pre = cur;
			cur = cur.left;
			return traverse(cur, pre, target);
		}
	}

	private TreeNode findLeftMost(TreeNode node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}
}
