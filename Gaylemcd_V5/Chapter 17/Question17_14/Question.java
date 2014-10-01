package Question17_14;

import java.util.Hashtable;

import CtCILibrary.AssortedMethods;
import CtCILibrary.Trie;

public class Question {

	public static String sentence;
	public static Trie dictionary;

	public static int parseOptimized(int wordStart, int wordEnd,
			Hashtable<Integer, Integer> cache) {
		if (wordEnd >= sentence.length()) {
			return wordEnd - wordStart;
		}
		if (cache.containsKey(wordStart)) {
			return cache.get(wordStart);
		}

		String currentWord = sentence.substring(wordStart, wordEnd + 1);
		boolean validPartial = dictionary.contains(currentWord, false);

		/* break current word */
		int bestExact = parseOptimized(wordEnd + 1, wordEnd + 1, cache);
		if (!validPartial || !dictionary.contains(currentWord, true)) {
			bestExact += currentWord.length();
		}

		/* extend current word */
		int bestExtend = Integer.MAX_VALUE;
		if (validPartial) {
			bestExtend = parseOptimized(wordStart, wordEnd + 1, cache);
		}

		/* find best */
		int min = Math.min(bestExact, bestExtend);
		cache.put(wordStart, min);
		return min;
	}

	public static int parseSimple(int wordStart, int wordEnd) {
		// this method doesn't work
		if (wordEnd >= sentence.length()) {
			return wordEnd - wordStart;
		}

		String word = sentence.substring(wordStart, wordEnd + 1);

		/* break current word */
		int bestExact = parseSimple(wordEnd + 1, wordEnd + 1);
		if (!dictionary.contains(word, true)) {
			bestExact += word.length();
		}

		/* extend current word */
		int bestExtend = parseSimple(wordStart, wordEnd + 1);

		/* find best */
		return Math.min(bestExact, bestExtend);
	}

	public static void main(String[] args) {

		int v;
		dictionary = AssortedMethods.getTrieDictionary();
		sentence = clean("As one of the top companies in the world, Google will surely attract the attention of computer gurus. This does not, however, mean the company is for everyone.");
		System.out.println(sentence);

		// v = parseSimple(0, 0);
		// System.out.println("simple answer is " + v);
		v = parseOptimized(0, 0, new Hashtable<Integer, Integer>());
		System.out.println("optimized answer is " + v);
		System.out.println();

//		sentence = "As one of the top TozT companies.";
//		sentence = clean(sentence);
//		System.out.println(sentence);
		v = MyAnswer.parse(sentence, dictionary);
		System.out.println("my answer is " + v);
		System.out.println();

		System.out.println("Parsed document: ");
		Result vv = Result.parse(sentence, dictionary, 0, 0,
				new Hashtable<Integer, Result>());
		System.out.println(vv.parsed);
	}

	public static String clean(String str) {
		char[] punctuation = { ',', '"', '!', '.', '\'', '?', ',' };
		for (char c : punctuation) {
			str = str.replace(c, ' ');
		}
		return str.replace(" ", "").toLowerCase();
	}

}
