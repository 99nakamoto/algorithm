package codility.lesson3;

//https://codility.com/programmers/lessons/3

//Write a function:
//class Solution { public int solution(int A, int B, int K); }
//that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:
//		{ i : A ≤ i ≤ B, i mod K = 0 }
//		For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.
//		Assume that:
//		A and B are integers within the range [0..2,000,000,000];
//		K is an integer within the range [1..2,000,000,000];
//		A ≤ B.
//		Complexity:
//		expected worst-case time complexity is O(1);
//		expected worst-case space complexity is O(1).

public class CountDiv {

	public static void main(String[] args) {
		CountDiv ins = new CountDiv();
		long startTime = System.currentTimeMillis();

		System.out.println("Start Run... ");
		System.out.println("result is " + ins.solution(5 ,10 ,5 ));
		System.out.println("result is " + ins.solution(6 ,11 ,5 ));
		System.out.println("result is " + ins.solution(0 ,10 ,5 ));

		System.out.print("Total time = ");
		System.out.print((System.currentTimeMillis() - startTime) / 1000.0);
	}

	public int solution(int A, int B, int K) {
		// write your code in Java SE 8
		int first = A == 0 ? 0 : (A - 1) / K + 1;
		int last = B / K;
		return last - first + 1;
	}
}
