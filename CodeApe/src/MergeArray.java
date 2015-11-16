public class MergeArray {

	public static void main(String[] args) {
		MergeArray ins = new MergeArray();
		long startTime = System.currentTimeMillis();

		System.out.println("Start Run... ");
		int[] a = { 1, 2, 3, 6 };
		int[] b = { 4, 5 };

		int[] c = ins.mergeArrays(a, b);
		for (int i : c) {
			System.out.print(i + " ");
		}

		System.out.print("Total time = ");
		System.out.print((System.currentTimeMillis() - startTime) / 1000.0);
	}

	public int[] mergeArrays(int[] a, int[] b) {
		

		int len1 = a.length;
		int len2 = b.length;
		int[] res = new int[len1 + len2];

		int p1 = 0;
		int p2 = 0;
		int p3 = 0;
		int val1 = 0;
		int val2 = 0;

		while (p3 != len1 + len2) {
			val1 = p1 == len1 ? Integer.MAX_VALUE : a[p1];
			val2 = p2 == len2 ? Integer.MAX_VALUE : b[p2];
			if (val1 < val2) {
				res[p3++] = a[p1++];
			} else {
				res[p3++] = b[p2++];
			}
		}

		return res;
	}
}
