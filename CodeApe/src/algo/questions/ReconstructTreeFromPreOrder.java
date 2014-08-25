package algo.questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import common.ListNode;
import common.TreeNode;

public class ReconstructTreeFromPreOrder {

	ListNode curNode = null;

	public static void main(String[] args) {
		ReconstructTreeFromPreOrder ins = new ReconstructTreeFromPreOrder();
		ListNode list1 = ListNode.arrayToList(new int[] { 1, 2, 1, 2, 2 });
		ListNode list2 = ListNode.arrayToList(new int[] { 1, 1, 2, 1, 1, 1, 2,
				2, 1, 2, 2, 2, 2 });

		ins.test(list1, 3);
		ins.test(list2, 6);
	}

	private void test(ListNode node, int level) {
		System.out.println("Test: ");
		this.curNode = node;
		TreeNode tree = constructTree();
		ArrayList<ArrayList<Integer>> levelOrder = printTree(tree, level);
		for (int i = 0; i < level; i++) {
			for (int k = 0; k < level - i; k++) {
				System.out.print("   ");
			}
			for (int j = 0; j < levelOrder.get(i).size(); j++) {
				System.out.print(levelOrder.get(i).get(j));
				for (int k = 0; k < level - i; k++) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	private TreeNode constructTree() {
		if (curNode == null) {
			return null;
		}
		TreeNode root = new TreeNode(curNode.val);
		curNode = curNode.next;

		if (root.val == 1) {
			root.left = constructTree();
			root.right = constructTree();
		}
		return root;
	}

	private ArrayList<ArrayList<Integer>> printTree(TreeNode root, int level) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return ans;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		for (int k = 0; k < level; k++) {
			ans.add(new ArrayList<Integer>());
			int curSize = q.size();
			for (int i = 0; i < curSize; i++) {
				TreeNode node = q.remove();
				ans.get(ans.size() - 1).add(node.val);
				if (node.left == null || node.val == 0) {
					q.add(new TreeNode(0));
					q.add(new TreeNode(0));
				} else {
					q.add(node.left);
					q.add(node.right);
				}
			}
		}
		return ans;
	}
}
