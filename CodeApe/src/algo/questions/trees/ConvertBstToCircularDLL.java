package algo.questions.trees;

import common.Common;
import common.TreeNode;

public class ConvertBstToCircularDLL {

	public static TreeNode convertBstToDLL(TreeNode root) {
		// convert bst to circular dll 
		if (root == null)
			return (null);

		// Recursively do the subtrees (leap of faith!)
		TreeNode lln = convertBstToDLL(root.left);
		TreeNode rrn = convertBstToDLL(root.right);

		// Make root a circular DLL
		root.left = root;
		root.right = root;

		// At this point we have three lists, merge them
		lln = appendDLL(lln, root);
		lln = appendDLL(lln, rrn);

		return lln;
	}

	public static TreeNode appendDLL(TreeNode a, TreeNode b) {
		// append 2 circular DLL
		if (a == null)
			return b;
		if (b == null)
			return a;

		TreeNode aLast = a.left;
		TreeNode bLast = b.left;

		aLast.right = b;
		b.left = aLast;
		bLast.right = a;
		a.left = bLast;

		return a;
	}

	/*
	 * =======================================================================
	 * =======================================================================
	 * The following are all testing data/method
	 * =======================================================================
	 * =======================================================================
	 */

	public static void treeInsert(TreeNode root, int newData) {
		if (newData <= root.val) {
			if (root.left != null)
				treeInsert(root.left, newData);
			else
				root.left = new TreeNode(newData);
		} else {
			if (root.right != null)
				treeInsert(root.right, newData);
			else
				root.right = new TreeNode(newData);
		}
	}

	public static void printListFromLeft(TreeNode node) {
		TreeNode current = node;

		while (current != null) {
			System.out.print(Integer.toString(current.val) + " ");
			current = current.right;
			if (current == node)
				break;
		}
		System.out.println();
	}

	public static void printListFromRight(TreeNode node) {
		TreeNode current = node;

		while (current != null) {
			System.out.print(Integer.toString(current.val) + " ");
			current = current.left;
			if (current == node)
				break;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		treeInsert(root, 2);
		treeInsert(root, 1);
		treeInsert(root, 3);
		treeInsert(root, 5);

		System.out.println("Input tree:");
		System.out.print("inorder - ");
		Common.printTreeInorder(root); // 1 2 3 4 5
		System.out.println();
		System.out.println();

		System.out.println("Output list:");
		TreeNode head = convertBstToDLL(root);
		System.out.print("left to right - ");
		printListFromLeft(head);
		System.out.print("right to left - ");
		printListFromRight(head.left);
	}
}
