import java.util.HashSet;

public class Solution {

	public static void main(String[] args) {
		Solution ins = new Solution();
		long startTime = System.currentTimeMillis();

		System.out.println("Code Ape Run... ");
		ins.add(0);
		ins.add(0);
		System.out.println(ins.find(0));

		System.out.print("Total time = ");
		System.out.print((System.currentTimeMillis() - startTime) / 1000.0);
	}

	HashSet<Integer> set = new HashSet<Integer>();

	public void add(int number) {
		for (int i : set) {
			set.add(i + number);
		}
	}

	public boolean find(int value) {
		return set.contains(value);
	}

	public void solve(int A) {
		
	}

}
