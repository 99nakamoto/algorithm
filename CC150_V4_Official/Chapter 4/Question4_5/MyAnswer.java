package Question4_5;

import CareerCupLibrary.TreeNode;

public class MyAnswer {

	public static TreeNode inorderSucc(TreeNode e) {
		if (e == null)
			return null;
		if (e.right != null) {
			TreeNode p = e.right;
			while (p.left != null) {
				p = p.left;
			}
			return p;
		} else {
			TreeNode p = e.parent;
			while (p != null && p.right == e) {
				e = p;
				p = e.parent;
			}
			return p;
		}
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		TreeNode root = TreeNode.createMinimalBST(array);
		for (int i = 0; i < array.length; i++) {
			TreeNode node = root.find(array[i]);
			TreeNode next = inorderSucc(node);
			if (next != null) {
				System.out.println(node.data + "->" + next.data);
			} else {
				System.out.println(node.data + "->" + null);
			}
		}
	}
}
