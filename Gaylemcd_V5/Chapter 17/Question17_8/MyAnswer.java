package Question17_8;

public class MyAnswer {

	public static int getMaxSum(int[] a) {
		int sofar = 0;
		int max = Integer.MIN_VALUE;
		for (int i : a) {
			int newNum = sofar + i;
			max = Math.max(max, newNum);
			sofar = Math.max(0, newNum);
		}
		return max;
	}

	public static void main(String[] args) {

		int[] a;

		a = new int[] { 2, -8, 3, -2, 4, -10 };
		System.out.println(getMaxSum(a));
	}
}
