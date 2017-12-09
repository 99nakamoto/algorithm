public class aaaTemplate {

	public static void main(String[] args) {
		aaaTemplate ins = new aaaTemplate();
		long startTime = System.currentTimeMillis();

		System.out.println("Start Run... ");

		int[] input = {1,2,3};
		System.out.println("ans = " + ins.increasingTriplet(input));

		System.out.print("Total time = ");
		System.out.print((System.currentTimeMillis() - startTime) / 1000.0);
	}

    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return false;
        }
        
        int len = nums.length;
        // dp[i] == true then there's increase sequence of 2
        boolean[] dp = new boolean[len]; 
        dp[0] = false;
        dp[1] = nums[0] < nums[1] ? true : false;
        for (int i = 2; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] == true) {
                        return true;
                    } else {
                        dp[i] = true;
                        break;
                    }
                }
            }
            dp[i] = false;
        }
        return false;
    }
}
