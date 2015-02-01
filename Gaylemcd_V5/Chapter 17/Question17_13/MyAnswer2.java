package Question17_13;

public class MyAnswer2 {

	public static BiNode convert(BiNode root) {
		BiNodePair res = helper(root);
		return res.leftMost;
	}

	private static BiNodePair helper(BiNode node) {
		if (node == null) {
			return null;
		}
		BiNodePair res = new BiNodePair(node, node);
		if (node.node1 != null) {
			BiNodePair leftRes = helper(node.node1);
			res.leftMost = leftRes.leftMost;
			leftRes.rightMost.node2 = node;
			node.node1 = leftRes.rightMost;
		}
		if (node.node2 != null) {
			BiNodePair rightRes = helper(node.node2);
			res.rightMost = rightRes.rightMost;
			rightRes.leftMost.node1 = node;
			node.node2 = rightRes.leftMost;
		}
		return res;
	}

	static class BiNodePair {
		BiNode leftMost;
		BiNode rightMost;

		public BiNodePair(BiNode node1, BiNode node2) {
			leftMost = node1;
			rightMost = node2;
		}
	}

	public static void main(String[] args) {
		BiNode root = QuestionC.createTree();
		QuestionC.printAsTree(root, "");
		BiNode r = convert(root);
		QuestionC.printLinkedListTree(r);
	}

}
