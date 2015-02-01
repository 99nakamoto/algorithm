package algo.questions.trees;

import common.Common;
import common.TreeNode;

public class StockSpanProblem {

	public static void main(String[] args) {
		StockSpanProblem ins = new StockSpanProblem();

		int[] input;
		int[] span;

		input = new int[] { 1 };
		span = ins.computeSpan(input);
		System.out.print("Input - ");
		Common.printArray(input);
		System.out.print("Span - ");
		Common.printArray(span);
		System.out.println();

		input = new int[] { 3, 4, 5, 6, 1, 2 };
		span = ins.computeSpan(input);
		System.out.print("Input - ");
		Common.printArray(input);
		System.out.print("Span - ");
		Common.printArray(span);
		System.out.println();

		input = new int[] { 2, 4, 6, 9, 5, 1 };
		span = ins.computeSpan(input);
		System.out.print("Input - ");
		Common.printArray(input);
		System.out.print("Span - ");
		Common.printArray(span);
		System.out.println();
	}

	public int[] computeSpan(int[] input) {
		int[] res = new int[input.length];

		TreeNodePlus root = new TreeNodePlus(input[0], 0);
		for (int i = 1; i < input.length; i++) {
			TreeNodePlus node = root.insertNum(input[i]);
			res[i] = root.findRank(node);
		}

		return res;
	}

	class TreeNodePlus extends TreeNode {
		int leftCount;
		int dupCount;

		public TreeNodePlus(int v, int leftC) {
			super(v);
			this.leftCount = leftC;
			this.dupCount = 1;
		}

		public int findRank(TreeNodePlus node) {
			TreeNodePlus leftBranch = (TreeNodePlus) this.left;
			TreeNodePlus rightBranch = (TreeNodePlus) this.right;

			if (this == node) {
				return 0;
			} else if (node.val < this.val) {
				if (this.left == null) {
					return 0;
				} else {
					return leftBranch.findRank(node);
				}
			} else {
				if (this.right == null) {
					return this.leftCount + this.dupCount;
				} else {
					return this.leftCount + this.dupCount
							+ rightBranch.findRank(node);
				}
			}
		}

		public TreeNodePlus insertNum(int num) {
			TreeNodePlus leftBranch = (TreeNodePlus) this.left;
			TreeNodePlus rightBranch = (TreeNodePlus) this.right;

			if (num == this.val) {
				this.dupCount++;
				return this;
			} else if (num < this.val) {
				// insert num to the left branch
				this.leftCount++;
				if (this.left == null) {
					this.left = new TreeNodePlus(num, 0);
					return (TreeNodePlus) this.left;
				} else {
					return leftBranch.insertNum(num);
				}
			} else {
				// insert num to the right branch
				// this.leftCount does not change
				if (this.right == null) {
					this.right = new TreeNodePlus(num, 0);
					return (TreeNodePlus) this.right;
				} else {
					return rightBranch.insertNum(num);
				}
			}
		}
	}
}
