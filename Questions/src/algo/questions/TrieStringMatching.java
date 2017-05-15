package algo.questions;

import java.util.Arrays;
import java.util.List;

import common.TrieNode;
import common.TrieRoot;

public class TrieStringMatching {

	public static void main(String[] args) {
		TrieStringMatching ins = new TrieStringMatching();
		long startTime = System.currentTimeMillis();

		System.out.println("Start Run... ");

		List<String> words = Arrays.asList("face", "book", "facebook");
		TrieRoot trie = new TrieRoot(words);
		
		System.out.println("The dictionary is: ");
		trie.printTrie();
		System.out.println();
		
		String word = null;
		System.out.println("Try matching " + word + " returned " + ins.solve(trie, word));
		
		word = "face";
		System.out.println("Try matching " + word + " returned " + ins.solve(trie, word));

		word = "fac";
		System.out.println("Try matching " + word + " returned " + ins.solve(trie, word));

		word = "fact";
		System.out.println("Try matching " + word + " returned " + ins.solve(trie, word));

		word = "facebook";
		System.out.println("Try matching " + word + " returned " + ins.solve(trie, word));

		word = "f*ce";
		System.out.println("Try matching " + word + " returned " + ins.solve(trie, word));

		word = "***k";
		System.out.println("Try matching " + word + " returned " + ins.solve(trie, word));

		word = "***t";
		System.out.println("Try matching " + word + " returned " + ins.solve(trie, word));

		word = "fa*c";
		System.out.println("Try matching " + word + " returned " + ins.solve(trie, word));

		word = "fac*boo*";
		System.out.println("Try matching " + word + " returned " + ins.solve(trie, word));

		word = "fac**o*";
		System.out.println("Try matching " + word + " returned " + ins.solve(trie, word));

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
		
		return matchFromChildren(trie.getRoot(), word, 0);
	}
	
	private boolean matchFromChildren(TrieNode node, String word, int index) {
		// [important note] 
		// regardless of the value of node.letter, match word[index...] from node.children
		
		if (index > word.length()) {
			// impossible to reach here
			return false;
		} else if (index == word.length()) {
			// word is now fully matched, check if isTerminalNode(node)
			return node.isEndOfWord();
		}
		
		char curLetter = word.charAt(index);
		if (curLetter == '*') {
			for (TrieNode child: node.getAllChildren()) {
				if (matchFromChildren(child, word, index + 1)) {
					return true;
				}
			}
			return false;
		} else {
			TrieNode nextNode = node.getChild(curLetter);
			if (nextNode == null) {
				return false;
			} else {
				return matchFromChildren(nextNode, word, index + 1);
			}
		}
	}
}
