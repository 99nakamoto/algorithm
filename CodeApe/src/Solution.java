import java.util.LinkedList;

public class Solution {

	public static boolean isPrime(long s) {
		for (long i = 2; i < s; i++) {
			if ((s % i) == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Solution p = new Solution();
		LinkedList<Long> arr = new LinkedList<Long>();
		for (long j = 2; j <= 999999; j++) {

			if (isPrime(j))
				arr.add(j);

		}
		// System.out.println("List of Prime Number are: "+ arr);
		long t = arr.get(10001);

		System.out.println("The Prime Number At 10001st position: " + t);
	}

}
