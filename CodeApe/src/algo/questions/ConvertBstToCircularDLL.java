package algo.questions;

import common.TreeNode;

public class ConvertBstToCircularDLL {

	/*
	 * Given an ordered binary tree, recursively change it into a circular
	 * doubly linked list which is returned.
	 */
	public static TreeNode treeToList(TreeNode root) {
		if (root == null)
			return (null);

		// Recursively do the subtrees (leap of faith!)
		TreeNode aList = treeToList(root.left);
		TreeNode bList = treeToList(root.right);

		// Make root a circular DLL
		root.left = root;
		root.right = root;

		// At this point we have three lists, merge them
		aList = append(aList, root);
		aList = append(aList, bList);

		return (aList);
	}

	/*
	 * given two circular doubly linked lists, append them and return the new
	 * list.
	 */
	public static TreeNode append(TreeNode a, TreeNode b) {
		if (a == null)
			return (b);
		if (b == null)
			return (a);

		TreeNode aLast = a.left;
		TreeNode bLast = b.left;

		aLast.right = b;
		b.left = aLast;
		bLast.right = a;
		a.left = bLast;

		return (a);
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

	public static void printTree(TreeNode root) {
		if (root == null)
			return;
		printTree(root.left);
		System.out.print(Integer.toString(root.val) + " ");
		printTree(root.right);
	}

	public static void printListFromLeft(TreeNode head) {
		TreeNode current = head;

		while (current != null) {
			System.out.print(Integer.toString(current.val) + " ");
			current = current.right;
			if (current == head)
				break;
		}
		System.out.println();
	}

	public static void printListFromRight(TreeNode tail) {
		TreeNode current = tail;

		while (current != null) {
			System.out.print(Integer.toString(current.val) + " ");
			current = current.left;
			if (current == tail)
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

		System.out.println("tree:");
		printTree(root); // 1 2 3 4 5
		System.out.println();

		System.out.println("list:");
		TreeNode head = treeToList(root);
		printListFromLeft(head);
		printListFromRight(head.left);
	}
}
