package algo.questions;

public class RemoveCharsPairs {

	public static void main(String args[]) {
		System.out.println(remove_pair("dfsaas".toCharArray()));
		System.out.println(remove_pair("ddffsaa".toCharArray()));
		System.out.println(remove_pair("dfsaasfdz33".toCharArray()));
	}

	public static String remove_pair(char[] input) {
		int len = input.length;
		int right = 1, left = 0;

		while (right < len) {
			// Cancel pairs
			while (right < len && left >= 0 && input[right] == input[left]) {
				right++;
				left--;
			}
			if (right == len) {
				break;
			}
			input[++left] = input[right++];
		}
		return String.valueOf(input).substring(0, left + 1);
	}
}
