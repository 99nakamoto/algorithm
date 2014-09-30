package Question17_13;

public class MyAnswer {

	public static BiNode convert(BiNode root) {
		if (root == null) {
			return null;
		}
		return helper(root);
	}

	private static BiNode helper(BiNode node) {
		// node is not null
		BiNode newHead = node;
		// do left part
		if (node.node1 != null) {
			newHead = helper(node.node1);
			BiNode leftTail = getListTail(newHead);
			leftTail.node2 = node;
			node.node1 = leftTail;
		}
		// do right part
		if (node.node2 != null) {
			BiNode rightHead = helper(node.node2);
			node.node2 = rightHead;
			rightHead.node1 = node;
		}
		return newHead;
	}

	private static BiNode getListTail(BiNode head) {
		// head is not null
		while (head.node2 != null) {
			head = head.node2;
		}
		return head;
	}

	public static void main(String[] args) {
		BiNode root = QuestionC.createTree();
		QuestionC.printAsTree(root, "");
		BiNode r = convert(root);
		QuestionC.printLinkedListTree(r);
	}

}
