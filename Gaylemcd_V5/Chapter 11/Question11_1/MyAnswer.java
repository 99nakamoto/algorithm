package Question11_1;

import CtCILibrary.AssortedMethods;

public class MyAnswer {

	public static void merge(int[] a, int[] b, int lastA, int lastB) {
		int p = lastA - 1;
		int q = lastB - 1;
		for (int i = lastA + lastB - 1; i >= 0; i--) {
			if (q == -1) {
				break;
			} else if (p == -1) {
				a[i] = b[q--];
			} else {
				if (a[p] < b[q]) {
					a[i] = b[q--];
				} else {
					a[i] = a[p--];
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] a = { 2, 3, 4, 5, 6, 8, 10, 100, 0, 0, 0, 0, 0, 0 };
		int[] b = { 1, 4, 5, 6, 7, 7 };
		merge(a, b, 8, 6);
		System.out.println(AssortedMethods.arrayToString(a));
	}

}
