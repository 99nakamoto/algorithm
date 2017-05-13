package algo.questions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class AllNumsGivenDecimalScale {

	// ���һ���ַ����Ƿ����kλa�����������б�ʾ��ʽ��
	// ��֤ԭ�ַ����������ִ����ǺϷ���kλa��������
	// "00110, a=2, k=2" => true ��������00��01��10��11����

	public static void main(String[] args) {
		AllNumsGivenDecimalScale ins = new AllNumsGivenDecimalScale();
		System.out.println(ins.containsAll("00100", 2, 2));
		System.out.println(ins.containsAll("10101", 2, 2));
		System.out.println(ins.containsAll("00110", 2, 2));
	}

	public boolean containsAll(String input, int k, int a) {
		// 1. build a hashmap from the input string
		int len = input.length();
		HashSet<String> set = new HashSet<String>();
		for (int i = 0; i <= len - k; i++) {
			set.add(input.substring(i, i + k));
		}
		// 2. generate all possible numbers for a����
		// for simplicity, just assume a <= 10
		List<String> nums = new ArrayList<String>();
		helper(nums, "", k, a);

		// 3. check each string in nums with the set
		for (String num : nums) {
			if (!set.contains(num)) {
				return false;
			}
		}
		return true;
	}

	private void helper(List<String> nums, String path, int digit, int base) {
		if (digit == 0) {
			nums.add(path);
			return;
		}
		for (int i = 0; i < base; i++) {
			helper(nums, path + i, digit - 1, base);
		}
	}
}
