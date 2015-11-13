public class Solution {

	public static void main(String[] args) {
		Solution ins = new Solution();
		long startTime = System.currentTimeMillis();

		System.out.println("Start Run... ");
		ins.solve(Integer.MIN_VALUE);

		System.out.print("Total time = ");
		System.out.print((System.currentTimeMillis() - startTime) / 1000.0);
	}

	public void solve(int A) {
		System.out.println(A);
		System.out.println(Integer.toBinaryString(A));
		System.out.println(A * -1);
		System.out.println(Integer.toBinaryString(-1 * A));
		System.out.println(-A);
	}
}
