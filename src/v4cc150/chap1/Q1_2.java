package v4cc150.chap1;

public class Q1_2 {

	// Write code to reverse a C-Style String (C-String means that
	// represented as five characters, including the null character )

	// Difficulty level: 1
	// Time Spend: 
	
	public static void main(String[] args) {
		Q1_2 s = new Q1_2();
		System.out.println(s.solve(null));
		System.out.println(s.solve(""));
		System.out.println(s.solve("0"));
		System.out.println(s.solve("abcdefg0"));
	}

	public String solve(String in) {
		if (in == null || in.length() <= 1) {
			return in;
		}
		int left = 0, right = in.length() - 2;
		char[] arr = in.toCharArray();
		while (left < right) {
			char temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
		return String.valueOf(arr);
	}
}