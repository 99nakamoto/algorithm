package algo.questions;

public class MaxBinaryGap {

	// Problem: Get maximum binary Gap.
	// For example, 9's binary form is 1001, the gap is 2.

	public static void main(String[] args) {
		MaxBinaryGap ins = new MaxBinaryGap();
		System.out.println(ins.solution(9) + "");
		System.out.println(ins.solution(4) + "");
		System.out.println(ins.solution(2) + "");
		System.out.println(ins.solution(65) + "");
	}

	private int solution(int num) {
		int max = 0;
		int boundary = -1;
		for (int i = 0; i < 32; i++) {
			int t = num & 1;
			num = num >> 1;
			if (t == 1) {
				if (boundary == -1) {
					boundary = i;
				} else {
					max = Math.max(max, i - boundary - 1);
					boundary = i;
				}
			}
		}
		return max;
	}
}
