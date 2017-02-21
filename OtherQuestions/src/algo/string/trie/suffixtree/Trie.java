package algo.string.trie.suffixtree;

public class Trie {
	TrieNode root;

	public Trie(String[] input) {
		root = new TrieNode(false);

		for (String str : input) {
			root.insert(str);
		}
	}

	public boolean search(String query) {
		return root.trieSearch(query);
	}
}
