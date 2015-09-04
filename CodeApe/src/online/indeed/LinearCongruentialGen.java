package online.indeed;

import java.util.ArrayList;
import java.util.List;

public class LinearCongruentialGen {

	public static void main(String[] args) {
		LinearCongruentialGen ins = new LinearCongruentialGen();

		ins.printFour(3, 2, 5, 1, 7);
		System.out.println();

		ins.printFour(1234, 5678, 123, 12345, 9876);
		System.out.println();
	}

	public void printFour(int A, int B, int X1, int K, int M) {
		// construct a list of cycle numbers
		List<Integer> valueList = new ArrayList<Integer>();
		valueList.add(X1);
		int cycleStart = -1;
		int next = this.getNext(A, X1, B, M);
		while (next != X1) {
			valueList.add(next);
			next = this.getNext(A, next, B, M);

			// found a cycle
			if (valueList.contains(next)) {
				cycleStart = valueList.indexOf(next);
				break;
			}
		}

		// now adjust value K
		int cycleLen = valueList.size() - cycleStart;
		int adjustedK;
		if (K > cycleStart)
			adjustedK = cycleStart + (K - cycleStart - 1) % cycleLen;
		else
			adjustedK = K - 1;

		// print Kth to (K+4)th
		for (int i = adjustedK; i <= adjustedK + 4; i++) {
			// print the (i)th element
			System.out.println(valueList.get(i % valueList.size()));
		}
	}

	private int getNext(int A, int Xn, int B, int M) {
		return (A * Xn + B) % M;
	}
}
