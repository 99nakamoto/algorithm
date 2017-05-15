package algo.questions;

import java.util.Arrays;
import java.util.List;

import common.TrieRoot;

public class TrieStringMatching {

	public static void main(String[] args) {
		TrieStringMatching ins = new TrieStringMatching();
		long startTime = System.currentTimeMillis();

		System.out.println("Start Run... ");

		List<String> words = Arrays.asList("face", "book", "facebook", "bible");
		TrieRoot trie = new TrieRoot(words);
		trie.printTrie();

		System.out.print("Total time = ");
		System.out.print((System.currentTimeMillis() - startTime) / 1000.0);
	}

	public boolean solve(TrieRoot trie, String word) {
		// you are allowed to use the following function:
		// getRoot()
		// getChild(node, letter)
		// getAllChildren(node)
		// isTerminalNode(node)
		
		if (word == null || word.length() == 0) {
			return false;
		}
		
		//TODO
		return true;
	}
}
