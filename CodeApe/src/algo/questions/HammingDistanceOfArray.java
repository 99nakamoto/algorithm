package algo.questions;

class HammingDistanceOfArray {

	int hammingDist(int[] nums) {

		int[] bits = new int[32];

		for (int i = 0; i < nums.length; i++) {
			int one = 1;
			int j = 0;

			while (nums[i] != 0) {
				if ((nums[i] & one) != 0)
					bits[j]++;
				j++;
				nums[i] = nums[i] >> 1;
			}
		}

		int ans = 0;
		for (int i = 0; i < 32; i++) {
			ans += bits[i] * (nums.length - bits[i]);
		}

		return ans;
	}

	public static void main(String[] args) {
		HammingDistanceOfArray ins = new HammingDistanceOfArray();
		int[] array;

		array = new int[] { 1, 2, 6 };
		System.out.println(ins.hammingDist(array));

		array = new int[] { 1, 1, 0, 0, 0, 0 };
		System.out.println(ins.hammingDist(array));
	}
}
