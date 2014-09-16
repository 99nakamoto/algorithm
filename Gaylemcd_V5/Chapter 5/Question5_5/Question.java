package Question5_5;

import CtCILibrary.AssortedMethods;

public class Question {
	public static int bitSwapRequired(int a, int b) {
		int count = 0;
		for (int c = a ^ b; c != 0; c = c >> 1) {
			count += c & 1;
		}
		return count;
	}

	public static int bitSwapRequired2(int a, int b) {
		int count = 0;
		for (int c = a ^ b; c != 0; c = c & (c - 1)) {
			count++;
		}
		return count;
	}

	public static int calcBitsSwapMe1(int a, int b) {
		int num = a ^ b;
		int count = 0;
		while (num != 0) {
			count += num & 1;
			num = num >>> 1;
		}
		return count;
	}

	public static int calcBitsSwapMe2(int a, int b) {
		int num = a ^ b;
		int count = 0;
		while (num != 0) {
			num = num & (num - 1);
			count++;
		}
		return count;
	}

	public static void main(String[] args) {

		int a = 23432;
		int b = 512132;
		System.out.println(a + ": " + AssortedMethods.toFullBinaryString(a));
		System.out.println(b + ": " + AssortedMethods.toFullBinaryString(b));

		int nbits = bitSwapRequired(a, b);
		int nbits2 = bitSwapRequired2(a, b);
		System.out.println("Required number of bits: " + nbits + " " + nbits2);

		int ans1 = calcBitsSwapMe1(a, b);
		int ans2 = calcBitsSwapMe2(a, b);
		System.out.println("My answer is: " + ans1 + " " + ans2);

	}
}
