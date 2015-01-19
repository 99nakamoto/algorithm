package algo.questions;

public class SieveOfE {

	private static final int INDEX = 10001;
	private static final int LIMIT = 1000000;

	private static int get10001stPrime() {
		boolean[] sieveArray = new boolean[LIMIT];
		int primeCount = 0;
		int currentNum = 2;
		while (primeCount < INDEX) {
			if (!sieveArray[currentNum]) {
				primeCount++;
				for (int i = currentNum; i < LIMIT; i += currentNum) {
					sieveArray[i] = true;
				}
			}
			currentNum++;
		}
		return currentNum - 1;
	}

	public static void main(String args[]) {
		System.out.println(INDEX + "th prime: " + get10001stPrime());
	}
}
