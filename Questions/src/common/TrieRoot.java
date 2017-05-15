package common;

import java.util.Collections;
import java.util.List;

public class TrieRoot {
	
	// declare private variables
	private TrieNode root;
	private int totalWordCount;
	
	// TrieNode constructor
	public TrieRoot() {
		root = new TrieNode('*');
		totalWordCount = 0;
	}

	public void addWord(String word){
		root.addSubword(word, 0);
		totalWordCount++;
	}

	public boolean containsWord(){
		// TODO
		return true;
	}
	
	public void printTrie() {
		List<String> allWords = root.listAllWords();
		Collections.sort(allWords);
		
		for (String word: allWords) {
			System.out.println(word);
		}
	}
	
	public static void main(String args[]) {
		System.out.println("start");
		TrieRoot trie = new TrieRoot();
		trie.addWord("face");
		trie.addWord("book");
		trie.addWord("facebook");
		trie.addWord("bible");
		trie.printTrie();
		System.out.println("end");
	}

}
