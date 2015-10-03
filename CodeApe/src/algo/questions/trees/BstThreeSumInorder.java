package algo.questions.trees;

import java.util.Stack;

import common.TreeNode;

public class BstThreeSumInorder {

	public static void main(String[] args) {
		BstThreeSumDLL ins = new BstThreeSumDLL();

		// test 1
		System.out.println("Test start");
		TreeNode tree1 = TreeNode.constructBstFromPreorder(new int[] { 4, 2, 1,
				3, 6, 5, 7 });
		ins.findTriplet(tree1, 14);
		System.out.println();

		// test 2
		System.out.println("2nd test");
		TreeNode tree2 = TreeNode.constructBstFromPreorder(new int[] { 8, 4, 2,
				1, 3, 6, 5, 7, 12, 10, 9, 11, 14, 13, 15 });
		ins.findTriplet(tree2, 7);
	}

	public void findTriplet(TreeNode root, int target) {
		
	}
	
	class TreeIterator {
		Stack<TreeNode> stack = new Stack<TreeNode>();
	}
}
