package Question4_7;

import CtCILibrary.TreeNode;

public class MyAnswer {

	public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		} else if (root == p) {
			return p;
		} else if (root == q) {
			return q;
		}
		if (commonAncestor(root.left, p, q) == null) {
			return commonAncestor(root.right, p, q);
		} else if (commonAncestor(root.right, p, q) == null) {
			return commonAncestor(root.left, p, q);
		} else {
			return root;
		}
	}

	public static void main(String[] args) {

		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		TreeNode root = TreeNode.createMinimalBST(array);
		TreeNode n3 = root.find(10);
		TreeNode n7 = root.find(6);

		TreeNode ancestor = commonAncestor(root, n3, n7);
		if (ancestor != null) {
			System.out.println(ancestor.data);
		} else {
			System.out.println("null");
		}
	}

}
