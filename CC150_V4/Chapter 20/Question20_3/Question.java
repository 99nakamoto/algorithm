package Question20_3;

import java.util.ArrayList;
import java.util.List;

import CareerCupLibrary.AssortedMethods;

public class Question {

	public static List<Integer> listRand = null;

	public static List<Integer> generateRand(int max, int count) {
		List<Integer> listRand = new ArrayList<Integer>();
		for (int low = 0; low < count; low++) {
			listRand.add(low + (int) (Math.random() * (max - low + 1)));
		}
		return listRand;
	}

	/*
	 * pick M elements from original array. Clone original array so that we
	 * don't destroy the input.
	 */
	public static int[] pickMRandomly(int[] original, int m) {
		int[] subset = new int[m];
		int[] array = original.clone();
		for (int j = 0; j < m; j++) {
			int index = listRand.get(j);
			subset[j] = array[index];
			array[index] = array[j]; // array[j] is now dead
		}
		return subset;
	}

	public static void main(String[] args) {

		// set up testin data and random values
		int[] cards = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(AssortedMethods.arrayToString(cards));
		listRand = generateRand(9, 4);

		// cc150 answer
		System.out.println();
		System.out.print("cc150 answer: ");
		int[] set1 = pickMRandomly(cards, 4);
		System.out.println(AssortedMethods.arrayToString(set1));

		// my answer
		System.out.println();
		System.out.print("my answer:    ");
		int[] set2 = MyAnswer.pickMRandomly(cards, 4);
		System.out.println(AssortedMethods.arrayToString(set2));

	}
}
