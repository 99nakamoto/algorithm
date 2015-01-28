package algo.string.trie.suffixtree;

public class TrieNode {
	boolean isLeaf;
	TrieNode[] child;

	public TrieNode(boolean isLeaf) {
		this.isLeaf = isLeaf;
		this.child = new TrieNode[26];
	}

	public void insert(String str) {
		if (str == null || str.length() == 0) {
			this.isLeaf = true;
			return;
		}
		char cur = str.charAt(0);
		if (child[cur - 'a'] == null) {
			child[cur - 'a'] = new TrieNode(str.length() == 1);
		}
		child[cur - 'a'].insert(str.substring(1));
	}

	public boolean trieSearch(String str) {
		// have to consider leaf node
		if (str == null || str.length() == 0) {
			return isLeaf;
		}
		char cur = str.charAt(0);
		if (child[cur - 'a'] == null) {
			return false;
		}
		return child[cur - 'a'].trieSearch(str.substring(1));
	}

	public boolean suffixTreeSearch(String str) {
		// suffixTreeSearch don't consider leaf node
		// cuz we search for prefix of suffixes
		if (str == null || str.length() == 0) {
			return true;
		}
		char cur = str.charAt(0);
		if (child[cur - 'a'] == null) {
			return false;
		}
		return child[cur - 'a'].suffixTreeSearch(str.substring(1));
	}
}
