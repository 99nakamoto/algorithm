package algo.questions.trees;

import java.util.ArrayList;
import java.util.List;

import common.Common;
import common.TreeNode;

public class NumSubtreeEvenNodes {

	public static void main(String[] args) {
		NumSubtreeEvenNodes ins = new NumSubtreeEvenNodes();
		long startTime = System.currentTimeMillis();

		System.out.println("Start Run... ");

		System.out.println("Test start");

		// the input
		TreeNode tree = TreeNode.constructBstFromPreorder(new int[] { 4, 2, 1, 3,
				6, 5, 7 });
		System.out.println("Input is a BST with this structure: ");
		Common.printLevelOrder(tree);
		System.out.println();

		// the output
		List<TreeNode> ans = new ArrayList<TreeNode>();
		ins.traverseAndFindEvenSubstrees(ans, tree);
		System.out.println("Total subtree count = " + ans.size());
		System.out.println("They are: ");
		int i = 1;
		for (TreeNode node : ans) {
			System.out.println("Tree " + i++ + ":");
			Common.printLevelOrder(node);
		}

		System.out.print("Total time = ");
		System.out.print((System.currentTimeMillis() - startTime) / 1000.0);
	}

	public void traverseAndFindEvenSubstrees(List<TreeNode> ans, TreeNode node) {
		if (node == null) {
			return;
		}
		List<TreeNode> evenSubtrees = this.getSubtrees(node, true);
		evenSubtrees.remove(null);
		ans.addAll(evenSubtrees);

		traverseAndFindEvenSubstrees(ans, node.left);
		traverseAndFindEvenSubstrees(ans, node.right);
	}

	private List<TreeNode> getSubtrees(TreeNode root, boolean isEven) {
		List<TreeNode> ans = new ArrayList<TreeNode>();
		if (root == null) {
			if (isEven) {
				// NULL is considered as a subtree with even number (0) of nodes
				ans.add(null);
			}
			return ans;
		}
		if (isEven) {
			// we need 2 subtrees to have a combined nodes of odd numbers
			for (int i = 0; i <= 1; i++) {
				List<TreeNode> leftGroup = getSubtrees(root.left, i == 0);
				List<TreeNode> rightGroup = getSubtrees(root.right, i != 0);
				// what we do here, is to make leftGroup and rightGroup have
				// different boolean parameter, thus a total of odd count
				for (TreeNode ln : leftGroup) {
					for (TreeNode rn : rightGroup) {
						// note that NULL is included in either leftGroup or
						// rightGroup. we'll use that
						TreeNode newSubtree = new TreeNode(root.val);
						newSubtree.left = ln;
						newSubtree.right = rn;
						ans.add(newSubtree);
					}
				}
			}
			// now we've added all subtrees into ans, whose head is the root
			// this means we does not inlcude NULL
		} else {
			for (int i = 0; i <= 1; i++) {
				List<TreeNode> leftGroup = getSubtrees(root.left, i == 0);
				List<TreeNode> rightGroup = getSubtrees(root.right, i == 0);
				for (TreeNode ln : leftGroup) {
					for (TreeNode rn : rightGroup) {
						TreeNode newSubtree = new TreeNode(root.val);
						newSubtree.left = ln;
						newSubtree.right = rn;
						ans.add(newSubtree);
					}
				}
			}
		}
		// now last step, add NULL (important)
		if (isEven) {
			ans.add(null);
		}
		return ans;
	}
}
