package algo.string.trie.suffixtree;

public class SuffixTree {
	TrieNode root;

	public SuffixTree(String input) {
		root = new TrieNode(false);

		for (int i = 0; i < input.length(); i++) {
			root.insert(input.substring(i));
		}
	}

	public boolean search(String query) {
		return root.suffixTreeSearch(query);
	}
}
