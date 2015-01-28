package algo.string.trie.suffixtree;

public class SuffixTreeTesting {

	public static void main(String[] args) {
		SuffixTreeTesting ins = new SuffixTreeTesting();

		String input = "banana";
		SuffixTree suffixTree = new SuffixTree(input);

		System.out.println(suffixTree.search(""));
		System.out.println(suffixTree.search("b"));
		System.out.println(suffixTree.search("a"));
		System.out.println(suffixTree.search("n"));
		System.out.println(suffixTree.search("an"));
		System.out.println(suffixTree.search("ba"));
		System.out.println(suffixTree.search("ana"));
		System.out.println(suffixTree.search("bana"));
		System.out.println(suffixTree.search("nana"));
		System.out.println(suffixTree.search("anana"));
		System.out.println(suffixTree.search("banana"));
		System.out.println();

		System.out.println(suffixTree.search("ab"));
		System.out.println(suffixTree.search("c"));
		System.out.println(suffixTree.search("nba"));
		System.out.println(suffixTree.search("bax"));
		System.out.println(suffixTree.search("xan"));
		System.out.println(suffixTree.search("nanan"));
	}

}
