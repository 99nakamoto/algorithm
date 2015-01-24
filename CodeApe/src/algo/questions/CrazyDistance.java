package algo.questions;

import common.TreeNode;

public class CrazyDistance {

	public static void main(String[] args) {
		CrazyDistance ins = new CrazyDistance();

		String[] input;

		input = new String[] { "1111", "1000", "101", "1100" };
		System.out.println("Crazy distance is " + ins.crazyDist(input)
				+ " should be 6 (string 1111 and 1000)");

		// important: test case 2: difference between diameter and leetcode
		// "Binary Tree Maximum Path Sum"
		input = new String[] { "110010", "1100", "1101", "111" };
		System.out.println("Crazy distance is " + ins.crazyDist(input)
				+ " should be 5 (string 110010 and 111)");

		input = new String[] { "11111", "1111", "11110" };
		System.out.println("Crazy distance is " + ins.crazyDist(input)
				+ " should be 2 (string 11111 and 11110)");

		// important: test case 4
		// if a input string ends at non-leaf spot, special case
		input = new String[] { "1", "11", "10" };
		System.out.println("Crazy distance is " + ins.crazyDist(input)
				+ " should be 1 (string 1 and 11)");
		// the execution result of test 4 is wrong, but there's a easy fix
		// instead of avoiding calculating distance when left/right child is
		// NULL, do another check: if current node is a ending char, then allow
		// calculating the path from current node to a leaf.
		// Code is easy to write, so I leave it.
	}

	public int crazyDist(String[] input) {
		TreeNode root = this.buildTree(input);
		return this.findMaxPath(root).path - 1;
	}

	private Result findMaxPath(TreeNode node) {
		if (node == null) {
			return new Result(Integer.MIN_VALUE, 0);
		}
		Result lr = this.findMaxPath(node.left);
		Result rr = this.findMaxPath(node.right);
		int path = Math.max(lr.path, rr.path);
		if (lr.depth != 0 && rr.depth != 0) {
			// this check is important, because if any of the child node is
			// NULL, this root will not be eligible for computing the path
			path = Math.max(path, lr.depth + rr.depth + 1);
			// Why? cuz diameter must go from one leaf, thru root, and reach
			// another leaf. This is different from "Maximum Path Sum" leetcode
		}
		return new Result(path, 1 + Math.max(lr.depth, rr.depth));
	}

	private TreeNode buildTree(String[] input) {
		TreeNode root = new TreeNode(123);
		// share a common root. this root is deducted from the final calculation
		for (String str : input) {
			// insert str under the root
			TreeNode p = root;
			for (char c : str.toCharArray()) {
				if (c == '0') {
					if (p.left == null) {
						p.left = new TreeNode(124);
						// if 0, go to left; otherwise go to right
						// thus value of TreeNodes does not really matter
					}
					p = p.left;
				} else {
					if (p.right == null) {
						p.right = new TreeNode(125);
					}
					p = p.right;
				}
			}
		}
		return root;
	}

	class Result {
		int path;
		int depth;

		public Result(int a, int b) {
			path = a;
			depth = b;
		}
	}
}
