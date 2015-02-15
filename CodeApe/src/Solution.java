import common.Common;

public class Solution {

	public static void main(String[] args) {
		Solution ins = new Solution();
		int[] input = new int[] { 1, 0, 2, 0, 3, 0, 4 };
		Common.printArray(input);

		ins.method1(input);
		Common.printArray(input);
	}

	public void method1(int[] input) {
		int p1 = 0;
		int p2 = 0;
		while (p2 < input.length) {
			if (input[p2] == 0) {
				p2++;
			} else {
				input[p1++] = input[p2++];
			}
		}
		while (p1 < input.length) {
			input[p1++] = 0;
		}
	}

}
