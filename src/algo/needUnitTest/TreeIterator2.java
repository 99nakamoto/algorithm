package algo.needUnitTest;

import java.util.Iterator;
import java.util.Stack;

import cc150.common.TreeNode;

class TreeIterator2 implements Iterator<TreeNode> {
	TreeNode root, cursor;
	Stack<TreeNode> iteratorStack;

	public TreeIterator2(TreeNode root) {
		this.root = root;
		this.cursor = root;
		this.iteratorStack = new Stack<TreeNode>();
	}

	public boolean hasNext() {
		return (!iteratorStack.empty() || cursor != null);
	}

	public TreeNode next() {
		TreeNode nextNodeValue;
		while (cursor != null) {
			iteratorStack.push(cursor);
			cursor = cursor.left;
		}
		cursor = iteratorStack.pop();
		nextNodeValue = cursor;
		cursor = cursor.right;
		return nextNodeValue;
	}

	@Override
	public void remove() {
	}
}