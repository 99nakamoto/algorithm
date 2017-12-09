package algo.questions.trees;
import common.TreeNode;

public class FindBstCeiling {

	public static void main(String[] args) {
		FindBstCeiling ins = new FindBstCeiling();
		long startTime = System.currentTimeMillis();

		System.out.println("Start Run... ");
		TreeNode tree = TreeNode.constructBstFromPreorder(new int[] { 40, 20, 10,
				30, 60, 50, 70 });
		for (int i = 0; i < 100; i++) {
			System.out.println("The ceiling of " + i + " is  "
					+ ins.findCeil(tree, i, Integer.MAX_VALUE));
		}

		System.out.print("Total time = ");
		System.out.print((System.currentTimeMillis() - startTime) / 1000.0);
	}

	public int findCeil(TreeNode node, int num, int found) {
		if (node != null) {
			if (num > node.val)
				return findCeil(node.right, num, found);
			else
				return findCeil(node.left, num, node.val);
		} else
			return found;
	}
}
