package common;

import java.util.Set;

public class TrieNode {
	public char letter;
	public boolean isEndOfWord;
	public Set<TrieNode> children;

	public TrieNode(char letter) {
		this.letter = letter;
	}

	public static TrieNode constructBstFromPreorder(int[] preorder) {
		p = 0;
		return buildBstHelper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static TrieNode buildBstHelper(int[] A, int min, int max) {
		int len = A.length;
		if (p >= len) {
			return null;
		} else if (A[p] < min || A[p] > max) {
			return null;
		}
		TrieNode root = new TrieNode(A[p]);
		p++;
		root.left = buildBstHelper(A, min, root.val);
		root.right = buildBstHelper(A, root.val, max);
		return root;
	}

	public static TrieNode constructTreeFromPreAndInorder(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null || preorder.length != inorder.length) {
			return null;
		}
		return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}

	private static TrieNode buildTreeHelper(int[] preorder, int a, int b, int[] inorder, int c, int d) {
		if (a > b || a == preorder.length) {
			return null;
		}
		int headVal = preorder[a];
		TrieNode head = new TrieNode(headVal);
		int p = c;
		while (p <= d) {
			if (inorder[p] == headVal) {
				break;
			}
			p++;
		}
		head.left = buildTreeHelper(preorder, a + 1, a + p - c, inorder, c, p - 1);
		head.right = buildTreeHelper(preorder, b - d + p + 1, b, inorder, p + 1, d);
		return head;
	}
}
