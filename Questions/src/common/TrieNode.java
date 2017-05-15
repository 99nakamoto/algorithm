package common;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TrieNode {
	
	// declare private variables
	private char letter;
	private boolean isEndOfWord;
	private Map<Character, TrieNode> children;
	
	// TrieNode constructor
	public TrieNode(char letter) {
		this.letter = letter;
		this.children = new HashMap<Character, TrieNode>();
	}

	// TrieNode addition function
	public void addSubword(String word, int index) {
		if (index == word.length()) {
			this.isEndOfWord = true;
			return;
		}
		
		char nextChar = word.charAt(index);
		if (!this.children.containsKey(nextChar)) {
			this.children.put(nextChar, new TrieNode(nextChar));
		}
		this.children.get(nextChar).addSubword(word, index + 1);
	}
	
	public Boolean hasChild(char letter) {
		return children.containsKey(letter);
	}
	
	public TrieNode getChild(char letter) {
		return children.get(letter);
	}
	
	public char getLetter(){
		return this.letter;
	}
	
	public boolean isEndOfWord(){
		return this.isEndOfWord;
	}
	
	// function to print words
	public List<String> listAllWords() {
		List<String> allWords = new LinkedList<String>();
		if (this.isEndOfWord) {
			allWords.add(this.letter + "");
		}
		for (TrieNode child: this.children.values()) {
			if (child != null) {
				for (String subword: child.listAllWords()) {
					allWords.add(this.letter + "-" + subword);
				}
			}
		}
		
		return allWords;
	}
}
