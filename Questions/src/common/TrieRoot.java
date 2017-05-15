package common;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TrieRoot {
	
	// declare private variables
	private TrieNode root;
	private int totalWordCount;
	
	// TrieNode constructor
	public TrieRoot(List<String> words) {
		root = new TrieNode('*');
		totalWordCount = 0;
		for (String word: words) {
			root.addSubword(word, 0);
		}
	}

	public void addWord(String word){
		root.addSubword(word, 0);
		totalWordCount++;
	}

	public boolean containsWord(){
		// TODO
		return true;
	}
	
	public TrieNode getRoot() {
		return this.root;
	}
	
	public int getTotalWordCount() {
		return this.totalWordCount;
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
		
		List<String> words = Arrays.asList("face", "book", "facebook", "bible");
		TrieRoot trie = new TrieRoot(words);
		trie.printTrie();
		
		System.out.println("end");
	}

}
