package algo.lowlevel;

import java.util.NoSuchElementException;
import java.util.Stack;

import cc150.common.TreeNode;

public class BinaryTreeIterator {

	// written by me
	// I refered to: http://blog.csdn.net/buhui912/article/details/10226433
	// But the above code uses parent pointer, so I changed the logic

	private Stack<TreeNode> stack = new Stack<TreeNode>();

	public BinaryTreeIterator(TreeNode root) {
		if (root == null) {
			throw new NoSuchElementException("Empty tree");
		}
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}

	public boolean hasNext() {
		return !stack.isEmpty();
	}

	public TreeNode next() {
		TreeNode top = stack.pop();
		TreeNode right = top.right;
		while (right != null) {
			stack.push(right);
			right = right.left;
		}
		return top;
	}

	public static void main(String[] args) {

		// build a BST tree with 7 elements (3 layers)
		int[] bstInorder = new int[] { 4, 2, 1, 3, 6, 5, 7 };
		TreeNode root = TreeNode.constructBstFromPreorder(bstInorder);

		// start the iterator of above tree
		BinaryTreeIterator iter = new BinaryTreeIterator(root);
		while (iter.hasNext()) {
			System.out.print(iter.next().val + " -> ");
		}
		System.out.println("end");
	}

}