package algo.needUnitTest;

import java.util.NoSuchElementException;

import cc150.common.TreeNode;

public class TreeIterator {

	// http://blog.csdn.net/buhui912/article/details/10226433

	private TreeNode next;

	public TreeIterator(TreeNode root) {
		next = root;
		if (next == null)
			return;
		while (next.left != null)
			next = next.left;
	}

	public boolean hasNext() {
		return next != null;
	}

	public TreeNode next() {
		if (!hasNext())
			throw new NoSuchElementException();
		TreeNode r = next;
		// if you can walk right, walk right, then fully left.
		// otherwise, walk up until you come from left.
		if (next.right != null) {
			next = next.right;
			while (next.left != null)
				next = next.left;
		} else
			while (true) {
				if (next.parent == null) {
					next = null;
					return r;
				}
				if (next.parent.left == next) {
					next = next.parent;
					return r;
				}
				next = next.parent;
			}
		return r;
	}
}