package algo.string.trie.suffixtree;

public class TrieTesting {

	public static void main(String[] args) {
		TrieTesting ins = new TrieTesting();

		String[] input = new String[] { "good", "morning", "evening", "night",
				"hello", "world" };
		Trie trie = new Trie(input);

		System.out.println(trie.search(null));
		System.out.println(trie.search(""));
		System.out.println();

		System.out.println(trie.search("good"));
		System.out.println(trie.search("hello"));
		System.out.println(trie.search("world"));
		System.out.println();

		System.out.println(trie.search("worl"));
		System.out.println(trie.search("goo"));
		System.out.println(trie.search("this"));
		System.out.println(trie.search("much"));
	}

}
