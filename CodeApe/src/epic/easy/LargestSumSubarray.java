package epic.easy;

public class LargestSumSubarray {

	public static void main(String[] args) {
		LargestSumSubarray ins = new LargestSumSubarray();

		System.out.println(ins.mySolution(new int[] { 1, 2, -2, -2, 7 }));
		System.out.println(ins.mySolution(new int[] { -1, -2, -2, -2, 7 }));
		System.out.println(ins.mySolution(new int[] { -1, -2, -2, -2, -7 }));
	}

	private int mySolution(int[] arr) {
		if (arr.length <= 1) {
			return 0;
		}
		int len = arr.length;
		int preSubarray = arr[0];
		int curMax = Integer.MIN_VALUE;
		for (int i = 1; i < len; i++) {
			curMax = Math.max(curMax, preSubarray + arr[i]);
			if (preSubarray < 0) {
				preSubarray = arr[i];
			} else {
				preSubarray += arr[i];
			}
		}
		return curMax;
	}

}
